/*
 * ProfileController.java
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

import services.ActorService;
import domain.Actor;
import forms.ActorForm;

@Controller
@RequestMapping("/")
public class ProfileController extends AbstractController {

	@Autowired
	private ActorService	actorService;

	@Autowired
	private Validator		validator;


	@RequestMapping("/about/cookies")
	public ModelAndView cookies() {
		ModelAndView result;

		result = new ModelAndView("about/cookies");

		return result;
	}

	@RequestMapping("/about/terms")
	public ModelAndView terms() {
		ModelAndView result;

		result = new ModelAndView("about/terms");

		return result;
	}

	@RequestMapping("/about/contact")
	public ModelAndView contact() {
		ModelAndView result;

		result = new ModelAndView("about/contact");

		return result;
	}

	@RequestMapping("/about/privacy")
	public ModelAndView privacy() {
		ModelAndView result;

		result = new ModelAndView("about/privacy");

		return result;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView result;
		final Actor act = this.actorService.getPrincipal();
		final ActorForm actor = new ActorForm();
		actor.setAddress(act.getAddress());
		actor.setEmail(act.getEmail());
		actor.setMiddleName(act.getMiddleName());
		actor.setName(act.getName());
		actor.setPhone(act.getPhone());
		actor.setPhoto(act.getPhoto());
		actor.setSurname(act.getSurname());
		result = new ModelAndView("actor/edit");
		result.addObject("actor", actor);
		result.addObject("readonly", "true");

		return result;
	}

	@RequestMapping(value = "profile/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		final Actor act = this.actorService.getPrincipal();
		final ActorForm actor = new ActorForm();
		actor.setAddress(act.getAddress());
		actor.setEmail(act.getEmail());
		actor.setMiddleName(act.getMiddleName());
		actor.setName(act.getName());
		actor.setPhone(act.getPhone());
		actor.setPhoto(act.getPhoto());
		actor.setSurname(act.getSurname());
		result = new ModelAndView("actor/edit");
		result.addObject("actor", actor);
		result.addObject("readonly", "false");
		return result;
	}

	@RequestMapping(value = "profile/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final ActorForm actor, final BindingResult result) {
		ModelAndView res = new ModelAndView("actor/edit");
		if (result.hasErrors()) {
			res.addObject("actor", actor);
			res.addObject("readonly", "false");
		} else
			try {
				final Actor act = this.actorService.getPrincipal();
				act.setAddress(actor.getAddress());
				act.setEmail(actor.getEmail());
				act.setMiddleName(actor.getMiddleName());
				act.setName(actor.getName());
				act.setPhone(actor.getPhone());
				act.setPhoto(actor.getPhoto());
				act.setSurname(actor.getSurname());
				this.validator.validate(act, result);
				this.actorService.save(act);
				res.addObject("actor", actor);
				res.addObject("readonly", "true");
			} catch (final Throwable oops) {
				res = new ModelAndView("welcome/index");
			}
		return res;
	}

}
