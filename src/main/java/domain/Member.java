
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Member extends Actor {

	//--------RelationShip-------

	private Collection<Enrolment>	enrolments;
	private Collection<March>		marchs;


	@OneToMany(mappedBy = "member")
	public Collection<Enrolment> getEnrolments() {
		return this.enrolments;
	}

	public void setEnrolments(final Collection<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	@OneToMany(mappedBy = "member")
	public Collection<March> getMarchs() {
		return this.marchs;
	}

	public void setMarchs(final Collection<March> marchs) {
		this.marchs = marchs;
	}
}
