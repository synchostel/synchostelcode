package cl.synchostel.ejb.interfaces;

import java.util.HashMap;

import javax.ejb.Remote;

@Remote
public interface PersonaEJBRemote {

	HashMap<String, Object> login(String run, String password);

}
