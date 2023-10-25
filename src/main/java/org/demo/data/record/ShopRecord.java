package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "SHOP" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class ShopRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 3)
	private String code; // String // Id or Primary Key

	@Size(max = 80)
	private String name; // String
	@Size(max = 80)
	private String address1; // String
	@Size(max = 80)
	private String address2; // String

	private Integer zipCode; // Integer
	@Size(max = 45)
	private String city; // String
	@NotNull
	@Size(min = 1, max = 2)
	private String countryCode; // String
	@Size(max = 14)
	private String phone; // String
	@Size(max = 50)
	private String email; // String
	@Size(max = 4)
	private String executive; // String

	/**
	 * Default constructor
	 */
	public ShopRecord() {
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
	 * Set the "address1" field value This field is mapped on the database
	 * column "ADDRESS_1" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Get the "address1" field value This field is mapped on the database
	 * column "ADDRESS_1" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getAddress1() {
		return this.address1;
	}

	/**
	 * Set the "address2" field value This field is mapped on the database
	 * column "ADDRESS_2" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param address2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Get the "address2" field value This field is mapped on the database
	 * column "ADDRESS_2" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getAddress2() {
		return this.address2;
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
	 * Set the "executive" field value This field is mapped on the database
	 * column "EXECUTIVE" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param executive
	 */
	public void setExecutive(String executive) {
		this.executive = executive;
	}

	/**
	 * Get the "executive" field value This field is mapped on the database
	 * column "EXECUTIVE" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getExecutive() {
		return this.executive;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(code);
		sb.append("|");
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
