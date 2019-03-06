/*
 * AdministratorController.java
 * 
 * Copyright (C) 2019 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import domain.Administrator;
import forms.AdministratorForm;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	// Constructors -----------------------------------------------------------
	@Autowired
	private AdministratorService	administratorService;

	@Autowired
	private Validator				validator;


	// Action-1 ---------------------------------------------------------------		

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView result;
		//final Administrator adm = this.administratorService.create();
		final AdministratorForm adm = new AdministratorForm();
		result = new ModelAndView("administrator/edit");
		result.addObject("administrator", adm);

		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView register(@Valid final AdministratorForm actor, final BindingResult result) {
		ModelAndView res = new ModelAndView("administrator/edit");
		if (result.hasErrors())
			res.addObject("administrator", actor);
		else
			try {
				final Administrator adm = this.administratorService.create();
				adm.setAddress(actor.getAddress());
				adm.setEmail(actor.getEmail());
				adm.setMiddleName(actor.getMiddleName());
				adm.setName(actor.getName());
				adm.setPhone(actor.getPhone());
				adm.setPhoto(actor.getPhoto());
				adm.setSurname(actor.getSurname());
				this.validator.validate(adm, result);
				this.administratorService.save(adm);
				res = new ModelAndView("welcome/index");

			} catch (final Throwable oops) {
				res = new ModelAndView("administrator/edit");
			}
		return res;
	}

	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView result;

		result = new ModelAndView("administrator/dashboard");

		result.addObject("query1", this.administratorService.query1());
		result.addObject("query2", this.administratorService.query2());
		result.addObject("query3", this.administratorService.query3());
		result.addObject("query4", this.administratorService.query4());
		result.addObject("query5", this.administratorService.query5());
		result.addObject("query6", this.administratorService.query6());
		result.addObject("query7", this.administratorService.query7());

		return result;
	}

}
