package cl.encumming.synchostel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.encumming.synchostel.dao.PersonaDAO;
import cl.encumming.synchostel.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

	private PersonaDAO personaDAO;
	
	public void setPersonaDAO(PersonaDAO personaDAO){
		this.personaDAO = personaDAO;
	}
	
	@Override
	@Transactional
	public void addPersona(Persona p) {
		this.personaDAO.addPersona(p);
	}

	@Override
	@Transactional
	public void updatePersona(Persona p) {
		this.personaDAO.updatePersona(p);
	}

	@Override
	@Transactional
	public List<Persona> getPersonas() {
		return this.personaDAO.getPersonas();
	}

	@Override
	@Transactional
	public Persona getPersonaById(int id) {
		return this.personaDAO.getPersonaById(id);
	}

	@Override
	@Transactional
	public void removePersona(int id) {
		this.personaDAO.removePersona(id);
	}

}
