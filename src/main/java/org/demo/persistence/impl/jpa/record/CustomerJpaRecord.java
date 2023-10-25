package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "Customer" entity stored in table "CUSTOMER" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "CUSTOMER", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "CustomerJpaRecord.countAll", query = "SELECT COUNT(x) FROM CustomerJpaRecord x"),
		@NamedQuery(name = "CustomerJpaRecord.countById", query = "SELECT COUNT(x) FROM CustomerJpaRecord x WHERE x.code = ?1 ") })
public class CustomerJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "CODE", nullable = false, length = 5)
	private String code;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "COUNTRY_CODE", nullable = false, length = 2)
	private String countryCode; // Foreign Key

	@Column(name = "FIRST_NAME", length = 40)
	private String firstName;

	@Column(name = "LAST_NAME", length = 40)
	private String lastName;

	@Column(name = "LOGIN", nullable = false, length = 20)
	private String login;

	@Column(name = "PASSWORD", length = 20)
	private String password;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "CITY", length = 45)
	private String city;

	@Column(name = "ZIP_CODE")
	private Integer zipCode;

	@Column(name = "PHONE", length = 20)
	private String phone;

	@Column(name = "REVIEWER")
	private Short reviewer;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public CustomerJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : COUNTRY_CODE ( VARCHAR )
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	// --- DATABASE MAPPING : FIRST_NAME ( VARCHAR )
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	// --- DATABASE MAPPING : LAST_NAME ( VARCHAR )
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	// --- DATABASE MAPPING : LOGIN ( VARCHAR )
	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	// --- DATABASE MAPPING : PASSWORD ( VARCHAR )
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	// --- DATABASE MAPPING : AGE ( INTEGER )
	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}

	// --- DATABASE MAPPING : CITY ( VARCHAR )
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	// --- DATABASE MAPPING : ZIP_CODE ( INTEGER )
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getZipCode() {
		return this.zipCode;
	}

	// --- DATABASE MAPPING : PHONE ( VARCHAR )
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	// --- DATABASE MAPPING : REVIEWER ( SMALLINT )
	public void setReviewer(Short reviewer) {
		this.reviewer = reviewer;
	}

	public Short getReviewer() {
		return this.reviewer;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(code);
		sb.append("]:");
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
