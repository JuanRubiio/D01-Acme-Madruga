
package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.BrotherhoodService;
import services.MemberService;
import forms.RegisterBrotherhoodForm;
import forms.RegisterMemberForm;

@Controller
@RequestMapping("/actor")
public class ActorController extends AbstractController {

	@Autowired
	private ActorService		actorService;

	@Autowired
	private MemberService		memberService;

	@Autowired
	private BrotherhoodService	brotherhoodService;


	//@Autowired
	//private AdministratorService	adminService;

	@RequestMapping(value = "/registerMember", method = RequestMethod.GET)
	public ModelAndView registerMember() {
		ModelAndView res;

		final RegisterMemberForm registerMemberForm = new RegisterMemberForm();

		res = this.createRegisterMemberModelAndView(registerMemberForm);

		return res;
	}

	@RequestMapping(value = "/registerBrotherhood", method = RequestMethod.GET)
	public ModelAndView registerBrotherhood() {
		ModelAndView res;

		final RegisterBrotherhoodForm registerBrotherhoodForm = new RegisterBrotherhoodForm();

		res = this.createRegisterBrotherhoodModelAndView(registerBrotherhoodForm);

		return res;
	}

	@RequestMapping(value = "/registerMember", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final RegisterMemberForm registerMemberForm, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors()) {
			System.out.println(binding.getAllErrors());
			res = this.registerMember();
		} else
			try {
				this.memberService.save(registerMemberForm);
				res = new ModelAndView("redirect:/");

			} catch (final Throwable oops) {
				System.out.println("catch");
				res = this.createRegisterMemberModelAndView(registerMemberForm, "actor.commit.error");

			}
		return res;
	}

	@RequestMapping(value = "/registerBrotherhood", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final RegisterBrotherhoodForm registerBrotherhoodForm, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors()) {
			System.out.println(binding.getAllErrors());
			res = this.registerMember();
		} else
			try {
				this.brotherhoodService.register(registerBrotherhoodForm);
				res = new ModelAndView("redirect:/");

			} catch (final Throwable oops) {
				System.out.println("catch");
				res = this.createRegisterBrotherhoodModelAndView(registerBrotherhoodForm, "actor.commit.error");
				oops.printStackTrace();

			}
		return res;
	}

	protected ModelAndView createRegisterMemberModelAndView(final RegisterMemberForm registerMemberForm) {
		ModelAndView res;

		res = this.createRegisterMemberModelAndView(registerMemberForm, null);

		return res;
	}

	protected ModelAndView createRegisterMemberModelAndView(final RegisterMemberForm registerMemberForm, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("actor/registerMember");
		res.addObject("registerMemberForm", registerMemberForm);
		res.addObject("message", messageCode);

		return res;
	}

	protected ModelAndView createRegisterBrotherhoodModelAndView(final RegisterBrotherhoodForm registerBrotherhoodForm) {
		ModelAndView res;

		res = this.createRegisterBrotherhoodModelAndView(registerBrotherhoodForm, null);

		return res;
	}

	protected ModelAndView createRegisterBrotherhoodModelAndView(final RegisterBrotherhoodForm registerBrotherhoodForm, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("actor/registerBrotherhood");
		res.addObject("registerBrotherhoodForm", registerBrotherhoodForm);
		res.addObject("message", messageCode);

		return res;
	}

}
