package cl.encumming.synchostel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import cl.encumming.synchostel.entity.Persona;

@Repository(value = "PersonaDAO")
public class JPAPersonaDAO implements PersonaDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(JPAPersonaDAO.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPersona(Persona p) {
		Session s = this.sessionFactory.getCurrentSession();
		s.persist(p);
		logger.info("Persona guardada. Persona: " + p);
	}

	@Override
	public void updatePersona(Persona p) {
		Session s = this.sessionFactory.getCurrentSession();
		s.update(p);
		logger.info("Persona actualizada. Persona: " + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonas() {
		Session s = this.sessionFactory.getCurrentSession();
		List<Persona> pList = s.createQuery("from Person").list();
		for (Persona p : pList) {
			logger.info("Lista Persona::" + p);
		}
		return pList;
	}

	@Override
	public Persona getPersonaById(int id) {
		Session s = this.sessionFactory.getCurrentSession();
		Persona p = (Persona) s.load(Persona.class, new Integer(id));
		logger.info("Persona cargada, Persona:" + p);
		return p;
	}

	@Override
	public void removePersona(int id) {
		Session s = this.sessionFactory.getCurrentSession();
		Persona p = (Persona) s.load(Persona.class, new Integer(id));
		if(null != p){
			s.delete(p);
		}
		logger.info("Person eliminada, Persona="+p);
	};
}
