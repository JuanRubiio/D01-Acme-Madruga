
package controllers.brotherhood;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.FloatService;
import controllers.AbstractController;

@Controller
@RequestMapping("/floatt/brotherhood")
public class FloattBrotherhoodController extends AbstractController {

	@Autowired
	private FloatService	floattService;


	//	@RequestMapping(value = "/show", method = RequestMethod.GET)
	//	public ModelAndView show(@RequestParam final int reportId) {
	//		ModelAndView res;
	//		Report report;
	//
	//		report = this.reportService.findOne(reportId);
	//
	//		res = this.createEditModelAndView(report);
	//
	//		return res;
	//	}
	//
	//	@RequestMapping(value = "/create", method = RequestMethod.GET)
	//	public ModelAndView create(@RequestParam final Integer complaintId) {
	//		ModelAndView res;
	//		final Report report;
	//		//hay q pasarle la queja lo qe nose es como
	//		report = this.reportService.create(complaintId);
	//
	//		res = this.createEditModelAndView(report);
	//
	//		return res;
	//	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<domain.Float> floatts;

		floatts = this.floattService.findAll();

		result = new ModelAndView("floatt/list");
		result.addObject("floatts", floatts);
		result.addObject("requestURI", "floatt/brotherhood/list.do");
		return result;
	}

	//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	//	public ModelAndView edit(@RequestParam final int reportId) {
	//		ModelAndView result;
	//		Report report;
	//		report = this.reportService.findOne(reportId);
	//		Assert.notNull(report);
	//		result = this.createEditModelAndView(report);
	//		return result;
	//	}

	//save
	//borrar

	protected ModelAndView createEditModelAndView(final Float floatt, final String messageCode) {
		ModelAndView result;
		result = new ModelAndView("floatt/edit");
		result.addObject("floatt", floatt);

		result.addObject("message", messageCode);
		return result;
	}

	protected ModelAndView createEditModelAndView(final Float floatt) {
		ModelAndView result;
		result = this.createEditModelAndView(floatt, null);
		return result;
	}

	//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	//	public ModelAndView delete(final Report report, final BindingResult binding) {
	//		ModelAndView res;
	//
	//		try {
	//			this.reportService.delete(report);
	//			res = new ModelAndView("redict:list.do");
	//		} catch (final Throwable oops) {
	//			res = this.createEditModelAndView(report, "report.commit.error");
	//		}
	//
	//		return res;
	//	}
	//
	//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	//	public ModelAndView save(@Valid final Report report, final BindingResult binding) {
	//		ModelAndView res;
	//
	//		if (binding.hasErrors())
	//			res = this.createEditModelAndView(report);
	//		else
	//			try {
	//				this.reportService.save(report);
	//				res = new ModelAndView("redict:list.do");
	//			} catch (final Throwable oops) {
	//				res = this.createEditModelAndView(report, "report.commit.error");
	//			}
	//
	//		return res;
	//	}
}
