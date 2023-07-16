package net.guides.springboot.Etudiantmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.guides.springboot.Etudiantmanagement.model.Etudiant;
import net.guides.springboot.Etudiantmanagement.service.IEtudiantService;

@Controller
public class EtudiantController {

	@Autowired
	private IEtudiantService EtudiantService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-Etudiants", method = RequestMethod.GET)
	public String showEtudiants(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("Etudiants1", EtudiantService.getEtudiantsByUser(name));
		// model.put("Etudiants", service.retrieveEtudiants(name));
		return "list-Etudiants";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-Etudiant", method = RequestMethod.GET)
	public String showAddEtudiantPage(ModelMap model) {
		model.addAttribute("Etudiant", new Etudiant());
		return "Etudiant";
	}

	@RequestMapping(value = "/delete-Etudiant", method = RequestMethod.GET)
	public String deleteEtudiant(@RequestParam long id) {
		EtudiantService.deleteEtudiant(id);
		// service.deleteEtudiant(id);
		return "redirect:/list-Etudiants";
	}

	@RequestMapping(value = "/update-Etudiant", method = RequestMethod.GET)
	public String showUpdateEtudiantPage(@RequestParam long id, ModelMap model) {
		Etudiant Etudiant = EtudiantService.getEtudiantById(id).get();
		model.put("Etudiant", Etudiant);
		return "Etudiant";
	}

	@RequestMapping(value = "/update-Etudiant", method = RequestMethod.POST)
	public String updateEtudiant(ModelMap model, @Valid Etudiant Etudiant, BindingResult result) {

		if (result.hasErrors()) {
			return "Etudiant";
		}

		Etudiant.setUserName(getLoggedInUserName(model));
		EtudiantService.updateEtudiant(Etudiant);
		return "redirect:/list-Etudiants";
	}

	@RequestMapping(value = "/add-Etudiant", method = RequestMethod.POST)
	public String addEtudiant(ModelMap model, @Valid Etudiant Etudiant, BindingResult result) {

		if (result.hasErrors()) {
			return "Etudiant";
		}

		Etudiant.setUserName(getLoggedInUserName(model));
		EtudiantService.saveEtudiant(Etudiant);
		return "redirect:/list-Etudiants";
	}
}
