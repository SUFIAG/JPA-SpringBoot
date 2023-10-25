package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "EMPLOYEE" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class EmployeeRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 4)
	private String code; // String // Id or Primary Key

	@NotNull
	@Size(min = 1, max = 3)
	private String shopCode; // String
	@Size(max = 40)
	private String firstName; // String
	@NotNull
	@Size(min = 1, max = 40)
	private String lastName; // String

	private Short manager; // Short

	private Integer badgeNumber; // Integer
	@Size(max = 60)
	private String email; // String

	/**
	 * Default constructor
	 */
	public EmployeeRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "code" field value This field is mapped on the database column
	 * "CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the "code" field value This field is mapped on the database column
	 * "CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getCode() {
		return this.code;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	/**
	 * Set the "shopCode" field value This field is mapped on the database
	 * column "SHOP_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param shopCode
	 */
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	/**
	 * Get the "shopCode" field value This field is mapped on the database
	 * column "SHOP_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getShopCode() {
		return this.shopCode;
	}

	/**
	 * Set the "firstName" field value This field is mapped on the database
	 * column "FIRST_NAME" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the "firstName" field value This field is mapped on the database
	 * column "FIRST_NAME" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Set the "lastName" field value This field is mapped on the database
	 * column "LAST_NAME" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get the "lastName" field value This field is mapped on the database
	 * column "LAST_NAME" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Set the "manager" field value This field is mapped on the database column
	 * "MANAGER" ( type "SMALLINT", NotNull : false )
	 * 
	 * @param manager
	 */
	public void setManager(Short manager) {
		this.manager = manager;
	}

	/**
	 * Get the "manager" field value This field is mapped on the database column
	 * "MANAGER" ( type "SMALLINT", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Short getManager() {
		return this.manager;
	}

	/**
	 * Set the "badgeNumber" field value This field is mapped on the database
	 * column "BADGE_NUMBER" ( type "INTEGER", NotNull : false )
	 * 
	 * @param badgeNumber
	 */
	public void setBadgeNumber(Integer badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	/**
	 * Get the "badgeNumber" field value This field is mapped on the database
	 * column "BADGE_NUMBER" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getBadgeNumber() {
		return this.badgeNumber;
	}

	/**
	 * Set the "email" field value This field is mapped on the database column
	 * "EMAIL" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the "email" field value This field is mapped on the database column
	 * "EMAIL" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getEmail() {
		return this.email;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(code);
		sb.append("|");
		sb.append(shopCode);
		sb.append("|");
		sb.append(firstName);
		sb.append("|");
		sb.append(lastName);
		sb.append("|");
		sb.append(manager);
		sb.append("|");
		sb.append(badgeNumber);
		sb.append("|");
		sb.append(email);
		return sb.toString();
	}

}
