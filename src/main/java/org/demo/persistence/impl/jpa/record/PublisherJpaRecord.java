package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "Publisher" entity stored in table "PUBLISHER" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "PUBLISHER", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "PublisherJpaRecord.countAll", query = "SELECT COUNT(x) FROM PublisherJpaRecord x"),
		@NamedQuery(name = "PublisherJpaRecord.countById", query = "SELECT COUNT(x) FROM PublisherJpaRecord x WHERE x.code = ?1 ") })
public class PublisherJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "CODE", nullable = false)
	private Integer code;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "COUNTRY_CODE", nullable = false, length = 2)
	private String countryCode; // Foreign Key

	@Column(name = "NAME", length = 45)
	private String name;

	@Column(name = "EMAIL", length = 45)
	private String email;

	@Column(name = "CONTACT", length = 45)
	private String contact;

	@Column(name = "CITY", length = 45)
	private String city;

	@Column(name = "ZIP_CODE")
	private Integer zipCode;

	@Column(name = "PHONE", length = 14)
	private String phone;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public PublisherJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
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

	// --- DATABASE MAPPING : NAME ( VARCHAR )
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// --- DATABASE MAPPING : EMAIL ( VARCHAR )
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	// --- DATABASE MAPPING : CONTACT ( VARCHAR )
	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return this.contact;
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
