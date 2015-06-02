package cl.encumming.synchostel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import cl.encumming.synchostel.entity.Persona;

@Repository(value="PersonaDAO")
public class JPAPersonaDAO implements PersonaDAO{
	
	private EntityManager em = null;
	
	@PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonas() {
		return em.createQuery("select p from Persona p order by p.run").getResultList();	
	}
	
	@Override
	public void savePersona(Persona p) {
		em.merge(p);
	}
}
