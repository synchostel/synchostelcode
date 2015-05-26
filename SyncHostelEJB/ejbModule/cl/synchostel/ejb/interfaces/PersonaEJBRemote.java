package cl.synchostel.ejb.interfaces;

import java.util.HashMap;

import javax.ejb.Remote;

import cl.synchostel.beans.Persona;

@Remote
public interface PersonaEJBRemote {
	
	public Persona login(Persona persona);
	public HashMap<String, Persona> login(HashMap<String,Persona> p);
}
