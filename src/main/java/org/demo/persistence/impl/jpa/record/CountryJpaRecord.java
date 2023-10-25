package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "Country" entity stored in table "COUNTRY" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "COUNTRY", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "CountryJpaRecord.countAll", query = "SELECT COUNT(x) FROM CountryJpaRecord x"),
		@NamedQuery(name = "CountryJpaRecord.countById", query = "SELECT COUNT(x) FROM CountryJpaRecord x WHERE x.code = ?1 ") })
public class CountryJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "CODE", nullable = false, length = 2)
	private String code;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "NAME", length = 45)
	private String name;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public CountryJpaRecord() {
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

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(code);
		sb.append("]:");
		sb.append(name);
		return sb.toString();
	}

}
