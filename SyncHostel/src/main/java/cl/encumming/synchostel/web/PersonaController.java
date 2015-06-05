package cl.encumming.synchostel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.encumming.synchostel.entity.Persona;
import cl.encumming.synchostel.service.PersonaService;

@Controller
public class PersonaController {
	private PersonaService personaService;

	@Autowired(required = true)
	@Qualifier(value = "personaService")
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@RequestMapping(value = "/personas", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("persona", new Persona());
		model.addAttribute("listaPersonas", this.personaService.getPersonas());
		return "persona";
	}

	// For add and update person both
	@RequestMapping(value = "/persona/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("persona") Persona p) {

		if (p.getRun().equals("")) {
			// new person, add it
			this.personaService.addPersona(p);
		} else {
			// existing person, call update
			this.personaService.updatePersona(p);
		}

		return "redirect:/personas";

	}

	@RequestMapping("persona/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.personaService.removePersona(id);
		return "redirect:/persons";
	}

	@RequestMapping("persona/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("persona", this.personaService.getPersonaById(id));
		model.addAttribute("listaPersonas", this.personaService.getPersonas());
		return "persona";
	}

}
