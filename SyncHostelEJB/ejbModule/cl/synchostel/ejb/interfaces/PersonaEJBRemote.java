package cl.synchostel.ejb.interfaces;

import javax.ejb.Remote;

import cl.synchostel.beans.Persona;

@Remote
public interface PersonaEJBRemote {
	
	public void login(Persona persona);
}
