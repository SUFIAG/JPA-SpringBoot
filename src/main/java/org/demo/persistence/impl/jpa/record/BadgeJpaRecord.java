package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for "Badge" entity stored in table "AUTHOR" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "BADGE", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "BadgeJpaRecord.countAll", query = "SELECT COUNT(x) FROM BadgeJpaRecord x"),
		@NamedQuery(name = "BadgeJpaRecord.countById", query = "SELECT COUNT(x) FROM BadgeJpaRecord x WHERE x.badgeNumber = ?1 ") })
public class BadgeJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "BADGE_NUMBER", nullable = false)
	private Integer badgeNumber;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "AUTHORIZATION_LEVEL", nullable = false)
	private Short authorizationLevel;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_OF_VALIDITY")
	private Date endOfValidity;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public BadgeJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setBadgeNumber(Integer badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public Integer getBadgeNumber() {
		return this.badgeNumber;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : AUTHORIZATION_LEVEL ( SMALLINT )
	public void setAuthorizationLevel(Short authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}

	public Short getAuthorizationLevel() {
		return this.authorizationLevel;
	}

	// --- DATABASE MAPPING : END_OF_VALIDITY ( DATE )
	public void setEndOfValidity(Date endOfValidity) {
		this.endOfValidity = endOfValidity;
	}

	public Date getEndOfValidity() {
		return this.endOfValidity;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(badgeNumber);
		sb.append("]:");
		sb.append(authorizationLevel);
		sb.append("|");
		sb.append(endOfValidity);
		return sb.toString();
	}

}
