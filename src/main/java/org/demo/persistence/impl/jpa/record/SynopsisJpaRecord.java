package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "Synopsis" entity stored in table "SYNOPSIS" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "SYNOPSIS", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "SynopsisJpaRecord.countAll", query = "SELECT COUNT(x) FROM SynopsisJpaRecord x"),
		@NamedQuery(name = "SynopsisJpaRecord.countById", query = "SELECT COUNT(x) FROM SynopsisJpaRecord x WHERE x.bookId = ?1 ") })
public class SynopsisJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "BOOK_ID", nullable = false)
	private Integer bookId; // Foreign Key

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "SYNOPSIS")
	private String synopsis;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public SynopsisJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : SYNOPSIS ( LONG VARCHAR )
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(bookId);
		sb.append("]:");
		// attribute 'synopsis' not usable (type = String Long Text)
		return sb.toString();
	}

}
