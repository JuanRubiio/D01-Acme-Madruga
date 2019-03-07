
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class March extends DomainEntity {

	//--------Atributos------------
	private String	status;
	private int		row;
	private int		column;
	private String	reason;


	//----------Get&Set-------------
	@NotBlank
	@Pattern(regexp = "^PENDING$|^REJECTED$|^APPROVED$")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	@NotNull
	@Min(value = 0, message = "El numero debe ser positivo")
	@Column(name = "`row`")
	public int getRow() {
		return this.row;
	}

	public void setRow(final int row) {
		this.row = row;
	}

	@NotNull
	@Min(value = 0, message = "El numero debe ser positivo")
	@Column(name = "`column`")
	public int getColumn() {
		return this.column;
	}

	public void setColumn(final int column) {
		this.column = column;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(final String reason) {
		this.reason = reason;
	}


	//-------------RelationShip-------------
	private Member		member;
	private Procession	procession;


	@NotNull
	@Valid
	@ManyToOne(optional = true)
	public Member getMember() {
		return this.member;
	}

	public void setMember(final Member member) {
		this.member = member;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = true)
	public Procession getProcession() {
		return this.procession;
	}

	public void setProcession(final Procession procession) {
		this.procession = procession;
	}
}
