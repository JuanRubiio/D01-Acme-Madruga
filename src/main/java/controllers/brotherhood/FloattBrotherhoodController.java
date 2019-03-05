
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

}
