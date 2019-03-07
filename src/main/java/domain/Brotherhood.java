
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Brotherhood extends Actor {

	private String				title;
	private Date				establishmentDate;
	private Collection<String>	photos;


	@NotBlank
	public String getTitle() {
		return this.title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}

	@Past
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getEstablishmentDate() {
		return this.establishmentDate;
	}
	public void setEstablishmentDate(final Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	@ElementCollection
	public Collection<String> getPhotos() {
		return this.photos;
	}
	public void setPhotos(final Collection<String> photos) {
		this.photos = photos;
	}


	//Relationships

	private Collection<Procession>	processions;
	private Collection<Float>		floats;
	private Collection<Enrolment>	enrolments;
	private Area					area;


	@OneToMany
	public Collection<Procession> getProcessions() {
		return this.processions;
	}
	public void setProcessions(final Collection<Procession> processions) {
		this.processions = processions;
	}

	@OneToMany
	public Collection<Float> getFloats() {
		return this.floats;
	}

	public void setFloats(final Collection<Float> floats) {
		this.floats = floats;
	}

	@OneToMany(mappedBy = "brotherhood")
	public Collection<Enrolment> getEnrolments() {
		return this.enrolments;
	}
	public void setEnrolments(final Collection<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	@Valid
	@ManyToOne(optional = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(final Area area) {
		this.area = area;
	}

}
