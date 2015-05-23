package cl.synchostel.ejb;

import cl.synchostel.ejb.interfaces.PersonaEJBLocal;
import cl.synchostel.ejb.interfaces.PersonaEJBRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PersonaEJB
 */
@Stateless
@LocalBean
public class PersonaEJB implements PersonaEJBRemote, PersonaEJBLocal {

    /**
     * Default constructor. 
     */
    public PersonaEJB() {
        // TODO Auto-generated constructor stub
    }

}
