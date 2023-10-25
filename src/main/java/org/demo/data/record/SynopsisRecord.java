package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "SYNOPSIS" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class SynopsisRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer bookId; // Integer // Id or Primary Key

	@Size(max = 32700)
	private String synopsis; // String

	/**
	 * Default constructor
	 */
	public SynopsisRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "bookId" field value This field is mapped on the database column
	 * "BOOK_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @param bookId
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * Get the "bookId" field value This field is mapped on the database column
	 * "BOOK_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getBookId() {
		return this.bookId;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	/**
	 * Set the "synopsis" field value This field is mapped on the database
	 * column "SYNOPSIS" ( type "LONG VARCHAR", NotNull : false )
	 * 
	 * @param synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * Get the "synopsis" field value This field is mapped on the database
	 * column "SYNOPSIS" ( type "LONG VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getSynopsis() {
		return this.synopsis;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(bookId);
		// attribute 'synopsis' not usable (type = String Long Text)
		return sb.toString();
	}

}
