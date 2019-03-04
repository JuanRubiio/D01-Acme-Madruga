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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import domain.Administrator;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	// Constructors -----------------------------------------------------------
	@Autowired
	private AdministratorService	administratorService;


	// Action-1 ---------------------------------------------------------------		

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView result;
		final Administrator adm = this.administratorService.create();
		result = new ModelAndView("actor/edit");
		result.addObject("administrator", adm);

		return result;
	}

	//	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	//	public ModelAndView register(@Valid final Administrator actor, final BindingResult result) {
	//		ModelAndView res = new ModelAndView("actor/edit");
	//		if (result.hasErrors())
	//			res.addObject("administrator", actor);
	//		else
	//			try {
	//				this.administratorService.save(actor);
	//				res = new ModelAndView("actor/edit");
	//				res.addObject("administrator", actor);
	//				res.addObject("readonly", "true");
	//			} catch (final Throwable oops) {
	//				res = new ModelAndView("actor/edit");
	//			}
	//		return res;
	//	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView saveCreate(@Valid final Administrator actor, final BindingResult result) {
		ModelAndView res = new ModelAndView("actor/edit");
		if (result.hasErrors())
			res.addObject("administrator", actor);
		else
			try {
				this.administratorService.save(actor);
				res = new ModelAndView("actor/edit");
				res.addObject("administrator", actor);
				res.addObject("readonly", "true");
			} catch (final Throwable oops) {
				res = new ModelAndView("actor/edit");
			}

		return res;
	}

	//	@RequestMapping("/dashboard")
	//	public ModelAndView dashboard() {
	//		ModelAndView result;
	//
	//		result = new ModelAndView("administrator/dashboard");
	//
	//		result.addObject("query1", this.administratorService.query1());
	//		result.addObject("query2", this.administratorService.query2());
	//		result.addObject("query3", this.administratorService.query3());
	//		result.addObject("query4", this.administratorService.query4());
	//		result.addObject("query5", this.administratorService.query5());
	//		result.addObject("query6", this.administratorService.query6());
	//		result.addObject("query7", this.administratorService.query7());
	//		result.addObject("query8", this.administratorService.query8());
	//		result.addObject("query9", this.administratorService.query9());
	//		result.addObject("query10", this.administratorService.query10());
	//
	//		return result;
	//	}

}
