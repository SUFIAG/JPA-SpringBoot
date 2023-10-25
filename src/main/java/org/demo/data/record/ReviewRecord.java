package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.util.Date;

/**
 * Java bean for entity "REVIEW" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class ReviewRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 5)
	private String customerCode; // String // Id or Primary Key
	@NotNull
	private Integer bookId; // Integer // Id or Primary Key

	@Size(max = 32700)
	private String reviewText; // String

	private Integer reviewNote; // Integer

	private Date creation; // Date

	private Date lastUpdate; // Date

	/**
	 * Default constructor
	 */
	public ReviewRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "customerCode" field value This field is mapped on the database
	 * column "CUSTOMER_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * Get the "customerCode" field value This field is mapped on the database
	 * column "CUSTOMER_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}

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
	 * Set the "reviewText" field value This field is mapped on the database
	 * column "REVIEW_TEXT" ( type "LONG VARCHAR", NotNull : false )
	 * 
	 * @param reviewText
	 */
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	/**
	 * Get the "reviewText" field value This field is mapped on the database
	 * column "REVIEW_TEXT" ( type "LONG VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getReviewText() {
		return this.reviewText;
	}

	/**
	 * Set the "reviewNote" field value This field is mapped on the database
	 * column "REVIEW_NOTE" ( type "INTEGER", NotNull : false )
	 * 
	 * @param reviewNote
	 */
	public void setReviewNote(Integer reviewNote) {
		this.reviewNote = reviewNote;
	}

	/**
	 * Get the "reviewNote" field value This field is mapped on the database
	 * column "REVIEW_NOTE" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getReviewNote() {
		return this.reviewNote;
	}

	/**
	 * Set the "creation" field value This field is mapped on the database
	 * column "CREATION" ( type "TIMESTAMP", NotNull : false )
	 * 
	 * @param creation
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}

	/**
	 * Get the "creation" field value This field is mapped on the database
	 * column "CREATION" ( type "TIMESTAMP", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Date getCreation() {
		return this.creation;
	}

	/**
	 * Set the "lastUpdate" field value This field is mapped on the database
	 * column "LAST_UPDATE" ( type "TIMESTAMP", NotNull : false )
	 * 
	 * @param lastUpdate
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Get the "lastUpdate" field value This field is mapped on the database
	 * column "LAST_UPDATE" ( type "TIMESTAMP", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(customerCode);
		sb.append("|");
		sb.append(bookId);
		// attribute 'reviewText' not usable (type = String Long Text)
		sb.append("|");
		sb.append(reviewNote);
		sb.append("|");
		sb.append(creation);
		sb.append("|");
		sb.append(lastUpdate);
		return sb.toString();
	}

}
