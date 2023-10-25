package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "CUSTOMER" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class CustomerRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 5)
	private String code; // String // Id or Primary Key

	@NotNull
	@Size(min = 1, max = 2)
	private String countryCode; // String
	@Size(max = 40)
	private String firstName; // String
	@Size(max = 40)
	private String lastName; // String
	@NotNull
	@Size(min = 1, max = 20)
	private String login; // String
	@Size(max = 20)
	private String password; // String

	private Integer age; // Integer
	@Size(max = 45)
	private String city; // String

	private Integer zipCode; // Integer
	@Size(max = 20)
	private String phone; // String

	private Short reviewer; // Short

	/**
	 * Default constructor
	 */
	public CustomerRecord() {
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
	 * column "LAST_NAME" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get the "lastName" field value This field is mapped on the database
	 * column "LAST_NAME" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Set the "login" field value This field is mapped on the database column
	 * "LOGIN" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Get the "login" field value This field is mapped on the database column
	 * "LOGIN" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Set the "password" field value This field is mapped on the database
	 * column "PASSWORD" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the "password" field value This field is mapped on the database
	 * column "PASSWORD" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the "age" field value This field is mapped on the database column
	 * "AGE" ( type "INTEGER", NotNull : false )
	 * 
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Get the "age" field value This field is mapped on the database column
	 * "AGE" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getAge() {
		return this.age;
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

	/**
	 * Set the "reviewer" field value This field is mapped on the database
	 * column "REVIEWER" ( type "SMALLINT", NotNull : false )
	 * 
	 * @param reviewer
	 */
	public void setReviewer(Short reviewer) {
		this.reviewer = reviewer;
	}

	/**
	 * Get the "reviewer" field value This field is mapped on the database
	 * column "REVIEWER" ( type "SMALLINT", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Short getReviewer() {
		return this.reviewer;
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
		sb.append(firstName);
		sb.append("|");
		sb.append(lastName);
		sb.append("|");
		sb.append(login);
		sb.append("|");
		sb.append(password);
		sb.append("|");
		sb.append(age);
		sb.append("|");
		sb.append(city);
		sb.append("|");
		sb.append(zipCode);
		sb.append("|");
		sb.append(phone);
		sb.append("|");
		sb.append(reviewer);
		return sb.toString();
	}

}
