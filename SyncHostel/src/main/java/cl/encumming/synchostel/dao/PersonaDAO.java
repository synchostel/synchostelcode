package cl.encumming.synchostel.dao;

import java.util.List;

import cl.encumming.synchostel.entity.Persona;

public interface PersonaDAO {
	public List<Persona> getPersonas();
	public void savePersona(Persona p);
}
