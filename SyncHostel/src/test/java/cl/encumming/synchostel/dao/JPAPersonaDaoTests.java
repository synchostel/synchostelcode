package cl.encumming.synchostel.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.encumming.synchostel.entity.Persona;

public class JPAPersonaDaoTests {
	private ApplicationContext context;
    private PersonaDAO PersonaDAO;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        PersonaDAO = (PersonaDAO) context.getBean("PersonaDAO");
    }

    @Test
    public void testGetPersonaList() {
        List<Persona> personas = PersonaDAO.getPersonas();
        assertEquals(personas.size(), 2, 0);	   
    }

    @Test
    public void testSaveProduct() {
        List<Persona> personas = PersonaDAO.getPersonas();

        Persona p = personas.get(0);
        System.out.println(p.toString());
        p.setEmail("pipi@caca.com");
        PersonaDAO.savePersona(p);

        /*
        List<Persona> updatedProducts = PersonaDAO.getPersonas();
        Persona p2 = updatedProducts.get(0);
        assertEquals(p2.getPrice(), 200.12, 0);

        p2.setPrice(price);
        PersonaDAO.saveProduct(p2);
        */
    }
}
