package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "Author" entity stored in table "AUTHOR" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "AUTHOR", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "AuthorJpaRecord.countAll", query = "SELECT COUNT(x) FROM AuthorJpaRecord x"),
		@NamedQuery(name = "AuthorJpaRecord.countById", query = "SELECT COUNT(x) FROM AuthorJpaRecord x WHERE x.id = ?1 ") })
public class AuthorJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "FIRST_NAME", length = 40)
	private String firstName;

	@Column(name = "LAST_NAME", length = 40)
	private String lastName;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public AuthorJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
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

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(firstName);
		sb.append("|");
		sb.append(lastName);
		return sb.toString();
	}

}
