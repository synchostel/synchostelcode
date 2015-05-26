package cl.synchostel.ejb;

import cl.synchostel.ejb.interfaces.PersonaEJBLocal;
import cl.synchostel.ejb.interfaces.PersonaEJBRemote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PersonaEJB
 */
@Stateless(mappedName = "SyncHostel/PersonaEJB")
public class PersonaEJB implements PersonaEJBRemote, PersonaEJBLocal {

    /**
     * Default constructor. 
     */
    public PersonaEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void hola(){
    	System.out.println("Hola");
    }
}
