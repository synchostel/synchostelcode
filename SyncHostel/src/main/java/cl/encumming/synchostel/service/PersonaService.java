package cl.encumming.synchostel.service;

import java.util.List;

import cl.encumming.synchostel.entity.Persona;

public interface PersonaService {
	public List<Persona> getPersonas();
	public void savePersona(Persona p);
}
