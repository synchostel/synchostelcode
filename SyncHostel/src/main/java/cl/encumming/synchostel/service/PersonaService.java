package cl.encumming.synchostel.service;

import java.util.List;

import cl.encumming.synchostel.entity.Persona;

public interface PersonaService {
	
	public void addPersona(Persona p);
	public void updatePersona(Persona p);
	public List<Persona> getPersonas();
	public Persona getPersonaById(int id);
	public void removePersona(int id);

}
