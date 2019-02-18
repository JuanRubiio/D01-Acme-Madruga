
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Configuration extends DomainEntity {

	// Atributos ---- 
	private String			banner;

	private String			system;

	private String			welcomMessageEng;

	private String			welcomMessageEsp;

	private String			countryCode;

	private int				finderDuration;

	private int				maxFiders;

	private int				absolutMaxFinders;

	private List<String>	positiveWords;

	private List<String>	negativeWords;

	private List<String>	positionEng;

	private List<String>	positionEsp;

	private List<String>	spam;


	@NotNull
	@Range(min = 60, max = 1440)
	public int getFinderDuration() {
		return this.finderDuration;
	}

	public void setFinderDuration(final int finderDuration) {
		this.finderDuration = finderDuration;
	}

	@URL
	public String getBanner() {
		return this.banner;
	}

	public void setBanner(final String banner) {
		this.banner = banner;
	}

	@NotBlank
	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	@NotNull
	@Range(min = 0, max = 10)
	public int getMaxFiders() {
		return this.maxFiders;
	}

	public void setMaxFiders(final int maxFiders) {
		this.maxFiders = maxFiders;
	}

	@NotNull
	@Range(min = 0, max = 100)
	public int getAbsolutMaxFinders() {
		return this.absolutMaxFinders;
	}

	public void setAbsolutMaxFinders(final int absolutMaxFinders) {
		this.absolutMaxFinders = absolutMaxFinders;
	}

	@NotBlank
	public String getSystem() {
		return this.system;
	}

	public void setSystem(final String system) {
		this.system = system;
	}

	@NotBlank
	public String getWelcomMessageEng() {
		return this.welcomMessageEng;
	}

	public void setWelcomMessageEng(final String welcomMessage) {
		this.welcomMessageEng = welcomMessage;
	}

	@NotBlank
	public String getWelcomMessageEsp() {
		return this.welcomMessageEsp;
	}

	public void setWelcomMessageEsp(final String welcomMessageEsp) {
		this.welcomMessageEsp = welcomMessageEsp;
	}

	@NotNull
	@ElementCollection
	public List<String> getPositiveWords() {
		return this.positiveWords;
	}

	public void setPositiveWords(final List<String> positiveWords) {
		this.positiveWords = positiveWords;
	}

	@NotNull
	@ElementCollection
	public List<String> getNegativeWords() {
		return this.negativeWords;
	}

	public void setNegativeWords(final List<String> negativeWords) {
		this.negativeWords = negativeWords;
	}

	@NotNull
	@ElementCollection
	public List<String> getPositionEng() {
		return this.positionEng;
	}

	public void setPositionEng(final List<String> position) {
		this.positionEng = position;
	}

	@NotNull
	@ElementCollection
	public List<String> getPositionEsp() {
		return this.positionEsp;
	}

	public void setPositionEsp(final List<String> positionEsp) {
		this.positionEsp = positionEsp;
	}

	@NotNull
	@ElementCollection
	public List<String> getSpam() {
		return this.spam;
	}

	public void setSpam(final List<String> spam) {
		this.spam = spam;
	}

}
