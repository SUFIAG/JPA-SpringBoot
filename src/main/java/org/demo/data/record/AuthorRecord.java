package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "AUTHOR" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class AuthorRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer id; // Integer // Id or Primary Key

	@Size(max = 40)
	private String firstName; // String
	@Size(max = 40)
	private String lastName; // String

	/**
	 * Default constructor
	 */
	public AuthorRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "id" field value This field is mapped on the database column "ID"
	 * ( type "INTEGER", NotNull : true )
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the "id" field value This field is mapped on the database column "ID"
	 * ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

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

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append("|");
		sb.append(firstName);
		sb.append("|");
		sb.append(lastName);
		return sb.toString();
	}

}
