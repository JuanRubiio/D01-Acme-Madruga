
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ProcessionService;
import domain.Procession;

@Controller
@RequestMapping("/procession")
public class ProcessionController extends AbstractController {

	@Autowired
	private ProcessionService	processionService;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		final Collection<Procession> processions = this.processionService.findAll();
		result = new ModelAndView("procession/list");
		result.addObject("requestURI", "procession/list.do");
		result.addObject("processions", processions);
		return result;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView display(final int processionId) {
		ModelAndView result;
		final Procession procession = this.processionService.findOne(processionId);
		result = new ModelAndView("procession/show");
		result.addObject("requestURI", "procession/show.do");
		result.addObject("procession", procession);
		return result;

	}
}
