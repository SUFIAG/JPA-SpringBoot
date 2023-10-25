package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "PUBLISHER" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class PublisherRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer code; // Integer // Id or Primary Key

	@NotNull
	@Size(min = 1, max = 2)
	private String countryCode; // String
	@Size(max = 45)
	private String name; // String
	@Size(max = 45)
	private String email; // String
	@Size(max = 45)
	private String contact; // String
	@Size(max = 45)
	private String city; // String

	private Integer zipCode; // Integer
	@Size(max = 14)
	private String phone; // String

	/**
	 * Default constructor
	 */
	public PublisherRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "code" field value This field is mapped on the database column
	 * "CODE" ( type "INTEGER", NotNull : true )
	 * 
	 * @param code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Get the "code" field value This field is mapped on the database column
	 * "CODE" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getCode() {
		return this.code;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	/**
	 * Set the "countryCode" field value This field is mapped on the database
	 * column "COUNTRY_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Get the "countryCode" field value This field is mapped on the database
	 * column "COUNTRY_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * Set the "name" field value This field is mapped on the database column
	 * "NAME" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the "name" field value This field is mapped on the database column
	 * "NAME" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getName() {
		return this.name;
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

	/**
	 * Set the "contact" field value This field is mapped on the database column
	 * "CONTACT" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Get the "contact" field value This field is mapped on the database column
	 * "CONTACT" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getContact() {
		return this.contact;
	}

	/**
	 * Set the "city" field value This field is mapped on the database column
	 * "CITY" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the "city" field value This field is mapped on the database column
	 * "CITY" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Set the "zipCode" field value This field is mapped on the database column
	 * "ZIP_CODE" ( type "INTEGER", NotNull : false )
	 * 
	 * @param zipCode
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Get the "zipCode" field value This field is mapped on the database column
	 * "ZIP_CODE" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getZipCode() {
		return this.zipCode;
	}

	/**
	 * Set the "phone" field value This field is mapped on the database column
	 * "PHONE" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get the "phone" field value This field is mapped on the database column
	 * "PHONE" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getPhone() {
		return this.phone;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(code);
		sb.append("|");
		sb.append(countryCode);
		sb.append("|");
		sb.append(name);
		sb.append("|");
		sb.append(email);
		sb.append("|");
		sb.append(contact);
		sb.append("|");
		sb.append(city);
		sb.append("|");
		sb.append(zipCode);
		sb.append("|");
		sb.append(phone);
		return sb.toString();
	}

}
