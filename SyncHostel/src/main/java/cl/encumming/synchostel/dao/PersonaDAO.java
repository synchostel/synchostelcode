package cl.encumming.synchostel.dao;

import java.util.List;

import cl.encumming.synchostel.entity.Persona;

public interface PersonaDAO {
	public void addPersona(Persona p);
	public void updatePersona(Persona p);
	public List<Persona> getPersonas();
	public Persona getPersonaById(int id);
	public void removePersona(int id);
}