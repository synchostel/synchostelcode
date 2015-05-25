package cl.synchostel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import cl.synchostel.entidades.Persona;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(Servlet.class);
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub;
		log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		//System.out.println(ejbPersona.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("login".equals(request.getParameter("accion"))){
			//Loggin del Usuario
			if(request.getSession().getAttribute("user")!=null){
				RequestDispatcher a =request.getRequestDispatcher("index.jsp");
				a.forward(request, response);
			}	
			login(request, response);
		}
	}
	
	void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona persona = new Persona();
		persona.login(request.getParameter("run"), request.getParameter("password"));
		if(persona.getNombre().equals("")){
			System.out.println("error");
		}
	}

}
