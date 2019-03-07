
package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;

import services.ConfigurationService;
import domain.Configuration;

@Controller
@RequestMapping("/configuration/administrator")
public class ConfigurationAdministratorController extends AbstractController {

	@Autowired
	private ConfigurationService	configurationService;


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show() {
		final ModelAndView res = new ModelAndView("configuration/edit");
		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationService.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		res.addObject("configuration", configlate);
		res.addObject("readonly", "true");

		return res;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		final ModelAndView res = new ModelAndView("configuration/edit");
		final Configuration configuration = this.configurationService.findAll().iterator().next();
		Assert.notNull(configuration);

		res.addObject("configuration", configuration);
		res.addObject("readonly", "false");

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Configuration configuration, final BindingResult result) {
		ModelAndView res = new ModelAndView("configuration/edit");
		if (result.hasErrors()) {
			res.addObject("configuration", configuration);
			res.addObject("readonly", "false");
		} else
			try {
				this.configurationService.save(configuration);
				res = new ModelAndView("configuration/edit");
				res.addObject("configuration", configuration);
				res.addObject("readonly", "true");
			} catch (final Throwable oops) {
				res = this.createEditModelAndView(configuration, "configuration.commit.error");
			}
		return res;
	}

	@RequestMapping(value = "/showSpam", method = RequestMethod.GET)
	public ModelAndView showSpam() {
		final ModelAndView res = new ModelAndView("configuration/showSpam");
		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationService.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;
		res.addObject("spam", configlate.getSpam());

		return res;
	}

	@RequestMapping(value = "/showWords", method = RequestMethod.GET)
	public ModelAndView showPositiveWords() {
		final ModelAndView res = new ModelAndView("configuration/showWords");
		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationService.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;
		res.addObject("positiveWords", configlate.getPositiveWords());
		res.addObject("negativeWords", configlate.getNegativeWords());

		return res;
	}

	//	@RequestMapping(value = "/showNegative", method = RequestMethod.GET)
	//	public ModelAndView showNegativeWords() {
	//		final ModelAndView res = new ModelAndView("configuration/showWords");
	//		final String negative = "negative";
	//		Configuration configlate = new Configuration();
	//		final Collection<Configuration> configurations = this.configurationService.findAll();
	//		for (final Configuration t : configurations)
	//			if (configurations.size() == 1)
	//				configlate = t;
	//		res.addObject("words", configlate.getNegativeWords());
	//		res.addObject("type", negative);
	//
	//		return res;
	//	}

	@RequestMapping(value = "/createSpam", method = RequestMethod.GET)
	public ModelAndView editSpam() {
		final ModelAndView result;
		final String word = new String();
		result = new ModelAndView("configuration/editSpamWord");
		result.addObject("word", word);

		return result;
	}

	@RequestMapping(value = "/createSpam", method = RequestMethod.POST, params = "save")
	public ModelAndView editSpam(@Valid final String word, final BindingResult result) {
		ModelAndView res = new ModelAndView();
		if (result.hasErrors()) {
			res = new ModelAndView("configuration/editSpamWord");
			res.addObject("word", word);
		} else
			try {
				this.configurationService.CreateSpamWord(word);
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				System.out.println(oops.getMessage());
			}
		return res;
	}

	@RequestMapping(value = "/deleteSpam", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam final String word) {
		final ModelAndView res = new ModelAndView("redirect:/configuration/administrator/show.do");
		try {
			this.configurationService.deleteSpamWord(word);

		} catch (final Throwable oops) {
			System.out.println(oops.getMessage());

		}

		return res;
	}

	@RequestMapping(value = "/positive/edit", method = RequestMethod.GET)
	public ModelAndView editPositive() {
		final ModelAndView result;
		final String word = new String();
		result = new ModelAndView("configuration/editWord");
		result.addObject("word", word);

		return result;
	}

	@RequestMapping(value = "/positive/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView editPositive(@Valid final String word, final BindingResult result) {
		ModelAndView res = new ModelAndView();
		if (result.hasErrors()) {
			res = new ModelAndView("configuration/editWord");
			res.addObject("word", word);
		} else
			try {
				this.configurationService.CreatePositiveWord(word);
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				System.out.println(oops.getMessage());
			}
		return res;
	}

	@RequestMapping(value = "/negative/edit", method = RequestMethod.GET)
	public ModelAndView editNegative() {
		final ModelAndView result;
		final String word = new String();
		result = new ModelAndView("configuration/editWord");
		result.addObject("word", word);

		return result;
	}

	@RequestMapping(value = "/negative/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView editNegative(@Valid final String word, final BindingResult result) {
		ModelAndView res = new ModelAndView();
		if (result.hasErrors()) {
			res = new ModelAndView("configuration/editWord");
			res.addObject("word", word);
		} else
			try {
				this.configurationService.CreateNegativeWord(word);
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				System.out.println(oops.getMessage());
			}
		return res;
	}

	private ModelAndView createEditModelAndView(final Configuration configuration) {
		ModelAndView result;

		result = this.createEditModelAndView(configuration, null);
		return result;
	}

	private ModelAndView createEditModelAndView(final Configuration configuration, final String messageCode) {
		ModelAndView result;

		result = new ModelAndView("configuration/edit");
		result.addObject("configuration", configuration);
		result.addObject("message", messageCode);
		return null;
	}

}
