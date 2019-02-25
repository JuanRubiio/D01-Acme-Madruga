
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Member extends Actor {

	//--------RelationShip-------
	private BrotherHood	brotherHood;


	@Valid
	@OneToOne(mappedBy = "member")
	public BrotherHood getBrotherHood() {
		return this.brotherHood;
	}

	public void setBrotherHood(final BrotherHood brotherHood) {
		this.brotherHood = brotherHood;
	}
}
