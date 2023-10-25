package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Persistent class for "Workgroup" entity stored in table "WORKGROUP" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "WORKGROUP", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "WorkgroupJpaRecord.countAll", query = "SELECT COUNT(x) FROM WorkgroupJpaRecord x"),
		@NamedQuery(name = "WorkgroupJpaRecord.countById", query = "SELECT COUNT(x) FROM WorkgroupJpaRecord x WHERE x.id = ?1 ") })
public class WorkgroupJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "ID", nullable = false)
	private Short id;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "NAME", nullable = false, length = 40)
	private String name;

	@Column(name = "DESCRIPTION", nullable = false, length = 600)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE", nullable = false)
	private Date creationDate;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public WorkgroupJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setId(Short id) {
		this.id = id;
	}

	public Short getId() {
		return this.id;
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

	// --- DATABASE MAPPING : DESCRIPTION ( VARCHAR )
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	// --- DATABASE MAPPING : CREATION_DATE ( DATE )
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(name);
		sb.append("|");
		sb.append(description);
		sb.append("|");
		sb.append(creationDate);
		return sb.toString();
	}

}
