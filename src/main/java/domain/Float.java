
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "`Float`")
public class Float extends DomainEntity {

	private String				title;
	private String				description;
	private Collection<String>	photos;


	@NotBlank
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@ElementCollection
	public Collection<String> getPhotos() {
		return this.photos;
	}

	public void setPhotos(final Collection<String> photos) {
		this.photos = photos;
	}

}
