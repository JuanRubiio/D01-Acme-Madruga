
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ConfigurationRepository;
import security.Authority;
import domain.Actor;
import domain.Configuration;

@Service
@Transactional
public class ConfigurationService {

	@Autowired
	private ConfigurationRepository	configurationRepository;

	@Autowired
	private ActorService			actorService;


	public Collection<Configuration> findAll() {
		Collection<Configuration> result;

		result = this.configurationRepository.findAll();

		Assert.notNull(result);

		return result;

	}

	public Configuration findOne(final Integer configurationId) {
		Configuration result;

		Assert.notNull(configurationId);

		result = this.configurationRepository.findOne(configurationId);

		Assert.notNull(result);

		return result;

	}

	public Configuration save(final Configuration configuration) {
		Configuration result;

		Assert.notNull(configuration);
		final Actor actor = this.actorService.getPrincipal();
		final Collection<Authority> autorities = actor.getUserAccount().getAuthorities();
		final ArrayList<String> listAuth = new ArrayList<String>();

		if (!autorities.isEmpty())
			for (final Authority au : autorities)
				listAuth.add(au.getAuthority());

		Assert.isTrue(listAuth.contains("ADMIN"));

		result = this.configurationRepository.save(configuration);

		Assert.notNull(result);

		return result;
	}

	//MANAGE LIST OF NEGATIVE AND POSITIVE WORDS SERVICES

	public List<String> getPositiveWords() {
		final List<String> positiveWords;
		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		positiveWords = configlate.getPositiveWords();

		return positiveWords;
	}

	public List<String> getNegativeWords() {
		final List<String> negativeWords;

		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		negativeWords = configlate.getNegativeWords();

		return negativeWords;
	}

	public void CreatePositiveWord(final String word) {

		Configuration configlate = new Configuration();
		List<String> positive = new ArrayList<>();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		Assert.isNull(configlate.getPositiveWords());
		Assert.isTrue(!configlate.getPositiveWords().contains(word));
		positive = configlate.getPositiveWords();
		positive.add(word);
		configlate.setPositiveWords(positive);
		this.save(configlate);

	}

	public void CreateNegativeWord(final String word) {

		Configuration configlate = new Configuration();
		List<String> positive = new ArrayList<>();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		Assert.isNull(configlate.getNegativeWords());
		Assert.isTrue(!configlate.getNegativeWords().contains(word));
		positive = configlate.getNegativeWords();
		positive.add(word);
		configlate.setNegativeWords(positive);
		this.save(configlate);

	}

	public void deletePositiveWord(final String word) {
		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		if (configlate.getPositiveWords().contains(word))
			configlate.getPositiveWords().remove(word);
		this.save(configlate);
	}

	public void deleteNegativeWord(final String word) {
		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		if (configlate.getNegativeWords().contains(word))
			configlate.getNegativeWords().remove(word);
		this.save(configlate);
	}

	public void deleteSpamWord(final String word) {
		Configuration configlate = new Configuration();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		if (configlate.getSpam().contains(word))
			configlate.getSpam().remove(word);
		this.save(configlate);
	}

	public void CreateSpamWord(final String word) {

		Configuration configlate = new Configuration();
		List<String> spam = new ArrayList<>();
		final Collection<Configuration> configurations = this.configurationRepository.findAll();
		for (final Configuration t : configurations)
			if (configurations.size() == 1)
				configlate = t;

		Assert.isNull(configlate.getSpam());
		Assert.isTrue(!configlate.getSpam().contains(word));
		spam = configlate.getSpam();
		spam.add(word);
		configlate.setSpam(spam);
		this.save(configlate);

	}

}
