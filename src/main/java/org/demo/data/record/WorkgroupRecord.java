package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.util.Date;

/**
 * Java bean for entity "WORKGROUP" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class WorkgroupRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Short id; // Short // Id or Primary Key

	@NotNull
	@Size(min = 1, max = 40)
	private String name; // String
	@NotNull
	@Size(min = 1, max = 600)
	private String description; // String
	@NotNull
	private Date creationDate; // Date

	/**
	 * Default constructor
	 */
	public WorkgroupRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "id" field value This field is mapped on the database column "ID"
	 * ( type "SMALLINT", NotNull : true )
	 * 
	 * @param id
	 */
	public void setId(Short id) {
		this.id = id;
	}

	/**
	 * Get the "id" field value This field is mapped on the database column "ID"
	 * ( type "SMALLINT", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Short getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	/**
	 * Set the "name" field value This field is mapped on the database column
	 * "NAME" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the "name" field value This field is mapped on the database column
	 * "NAME" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the "description" field value This field is mapped on the database
	 * column "DESCRIPTION" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the "description" field value This field is mapped on the database
	 * column "DESCRIPTION" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the "creationDate" field value This field is mapped on the database
	 * column "CREATION_DATE" ( type "DATE", NotNull : true )
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Get the "creationDate" field value This field is mapped on the database
	 * column "CREATION_DATE" ( type "DATE", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append("|");
		sb.append(name);
		sb.append("|");
		sb.append(description);
		sb.append("|");
		sb.append(creationDate);
		return sb.toString();
	}

}
