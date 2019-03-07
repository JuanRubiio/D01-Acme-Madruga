
package controllers.unauthenticated;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.AdministratorService;
import controllers.AbstractController;
import domain.Actor;

@Controller
@RequestMapping("/actor")
public class ActorUnauthenticatedController extends AbstractController {

	@Autowired
	private ActorService			actorService;

	@Autowired
	private AdministratorService	adminService;


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView res;
		Actor actor;
		final List<String> roles = new ArrayList<>();
		roles.add("Member");
		roles.add("Brotherhood");
		roles.add("Administrator");
		actor = this.adminService.create();
		res = new ModelAndView("actor/register");
		res.addObject("actor", actor);
		res.addObject("roles", roles);

		return res;
	}

	//TODO darle una vuelta a esto, ver como registrarte como handy worker o customer
	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Actor actor, final String role, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors()) {
			res = new ModelAndView("actor/edit");
			res.addObject("actor", actor);
		} else
			try {
				if (role.equals("Customer"))
					this.actorService.save(actor);
				else if (role.equals("Handy Worker")) {

				}
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				res = new ModelAndView("actor/edit");
				res.addObject("actor", actor);
				res.addObject("message", "actor.commit.error");
			}

		return res;
	}

}
