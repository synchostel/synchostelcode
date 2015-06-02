package cl.encumming.synchostel.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cl.encumming.synchostel.entity.Persona;

public class PersonaServiceImpl implements PersonaService {

	@Transactional
	@Override
	public List<Persona> getPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePersona(Persona p) {
		// TODO Auto-generated method stub

	}

}
