package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "Shop" entity stored in table "SHOP" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "SHOP", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "ShopJpaRecord.countAll", query = "SELECT COUNT(x) FROM ShopJpaRecord x"),
		@NamedQuery(name = "ShopJpaRecord.countById", query = "SELECT COUNT(x) FROM ShopJpaRecord x WHERE x.code = ?1 ") })
public class ShopJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "CODE", nullable = false, length = 3)
	private String code;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "NAME", length = 80)
	private String name;

	@Column(name = "ADDRESS_1", length = 80)
	private String address1;

	@Column(name = "ADDRESS_2", length = 80)
	private String address2;

	@Column(name = "ZIP_CODE")
	private Integer zipCode;

	@Column(name = "CITY", length = 45)
	private String city;

	@Column(name = "COUNTRY_CODE", nullable = false, length = 2)
	private String countryCode; // Foreign Key

	@Column(name = "PHONE", length = 14)
	private String phone;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "EXECUTIVE", length = 4)
	private String executive; // Foreign Key

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public ShopJpaRecord() {
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
	// --- DATABASE MAPPING : NAME ( VARCHAR )
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// --- DATABASE MAPPING : ADDRESS_1 ( VARCHAR )
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress1() {
		return this.address1;
	}

	// --- DATABASE MAPPING : ADDRESS_2 ( VARCHAR )
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress2() {
		return this.address2;
	}

	// --- DATABASE MAPPING : ZIP_CODE ( INTEGER )
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getZipCode() {
		return this.zipCode;
	}

	// --- DATABASE MAPPING : CITY ( VARCHAR )
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	// --- DATABASE MAPPING : COUNTRY_CODE ( VARCHAR )
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	// --- DATABASE MAPPING : PHONE ( VARCHAR )
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	// --- DATABASE MAPPING : EMAIL ( VARCHAR )
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	// --- DATABASE MAPPING : EXECUTIVE ( VARCHAR )
	public void setExecutive(String executive) {
		this.executive = executive;
	}

	public String getExecutive() {
		return this.executive;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(code);
		sb.append("]:");
		sb.append(name);
		sb.append("|");
		sb.append(address1);
		sb.append("|");
		sb.append(address2);
		sb.append("|");
		sb.append(zipCode);
		sb.append("|");
		sb.append(city);
		sb.append("|");
		sb.append(countryCode);
		sb.append("|");
		sb.append(phone);
		sb.append("|");
		sb.append(email);
		sb.append("|");
		sb.append(executive);
		return sb.toString();
	}

}
