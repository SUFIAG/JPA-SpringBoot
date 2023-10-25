package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "Review" ( stored in table "REVIEW" )
 *
 */
@Embeddable
public class ReviewJpaRecordKey implements Serializable {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY KEY ATTRIBUTES
	// ----------------------------------------------------------------------
	@Column(name = "CUSTOMER_CODE", nullable = false, length = 5)
	private String customerCode;

	@Column(name = "BOOK_ID", nullable = false)
	private Integer bookId;

	// ----------------------------------------------------------------------
	// CONSTRUCTORS
	// ----------------------------------------------------------------------
	public ReviewJpaRecordKey() {
		super();
	}

	public ReviewJpaRecordKey(String customerCode, Integer bookId) {
		super();
		this.customerCode = customerCode;
		this.bookId = bookId;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR KEY FIELDS
	// ----------------------------------------------------------------------
	public void setCustomerCode(String value) {
		this.customerCode = value;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setBookId(Integer value) {
		this.bookId = value;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	// ----------------------------------------------------------------------
	// equals METHOD
	// ----------------------------------------------------------------------
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		ReviewJpaRecordKey other = (ReviewJpaRecordKey) obj;
		// --- Attribute customerCode
		if (customerCode == null) {
			if (other.customerCode != null)
				return false;
		} else if (!customerCode.equals(other.customerCode))
			return false;
		// --- Attribute bookId
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	// ----------------------------------------------------------------------
	// hashCode METHOD
	// ----------------------------------------------------------------------
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		// --- Attribute customerCode
		result = prime * result + ((customerCode == null) ? 0 : customerCode.hashCode());
		// --- Attribute bookId
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());

		return result;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(customerCode);
		sb.append("|");
		sb.append(bookId);
		return sb.toString();
	}
}
