package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "COUNTRY" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class CountryRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 2)
	private String code; // String // Id or Primary Key

	@Size(max = 45)
	private String name; // String

	/**
	 * Default constructor
	 */
	public CountryRecord() {
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

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(code);
		sb.append("|");
		sb.append(name);
		return sb.toString();
	}

}
