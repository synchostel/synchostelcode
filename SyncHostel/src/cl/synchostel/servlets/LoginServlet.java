package cl.synchostel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.synchostel.beans.Persona;
import cl.synchostel.ejb.interfaces.PersonaEJBRemote;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "SyncHostel/PersonaEJB")
	private PersonaEJBRemote ejb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Capturo los parámetros envíados por el JSP
		
		Persona persona  = new Persona();
		
		String run = request.getParameter("run");
		String pass = request.getParameter("password");
		persona.setRut(run);
		persona.setPassword(pass);
		
		ejb.login(persona);
		
		if(persona.getPassword().equals(pass) && persona.getRut().equals(run)){
			//Se encontró, se guarda una Cookie y se inicia sesión
			response.sendRedirect("LoginSuccess.jsp");
		}
		else{
			//No se encontró, redirige al login avisando el error
		}
	}

}
