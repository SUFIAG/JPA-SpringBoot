package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.util.Date;

/**
 * Java bean for entity "BADGE" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class BadgeRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer badgeNumber; // Integer // Id or Primary Key

	@NotNull
	private Short authorizationLevel; // Short

	private Date endOfValidity; // Date

	/**
	 * Default constructor
	 */
	public BadgeRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "badgeNumber" field value This field is mapped on the database
	 * column "BADGE_NUMBER" ( type "INTEGER", NotNull : true )
	 * 
	 * @param badgeNumber
	 */
	public void setBadgeNumber(Integer badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	/**
	 * Get the "badgeNumber" field value This field is mapped on the database
	 * column "BADGE_NUMBER" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getBadgeNumber() {
		return this.badgeNumber;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	/**
	 * Set the "authorizationLevel" field value This field is mapped on the
	 * database column "AUTHORIZATION_LEVEL" ( type "SMALLINT", NotNull : true )
	 * 
	 * @param authorizationLevel
	 */
	public void setAuthorizationLevel(Short authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}

	/**
	 * Get the "authorizationLevel" field value This field is mapped on the
	 * database column "AUTHORIZATION_LEVEL" ( type "SMALLINT", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Short getAuthorizationLevel() {
		return this.authorizationLevel;
	}

	/**
	 * Set the "endOfValidity" field value This field is mapped on the database
	 * column "END_OF_VALIDITY" ( type "DATE", NotNull : false )
	 * 
	 * @param endOfValidity
	 */
	public void setEndOfValidity(Date endOfValidity) {
		this.endOfValidity = endOfValidity;
	}

	/**
	 * Get the "endOfValidity" field value This field is mapped on the database
	 * column "END_OF_VALIDITY" ( type "DATE", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Date getEndOfValidity() {
		return this.endOfValidity;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(badgeNumber);
		sb.append("|");
		sb.append(authorizationLevel);
		sb.append("|");
		sb.append(endOfValidity);
		return sb.toString();
	}

}
