package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "BookOrderItem" ( stored in table
 * "BOOK_ORDER_ITEM" )
 *
 */
@Embeddable
public class BookOrderItemJpaRecordKey implements Serializable {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY KEY ATTRIBUTES
	// ----------------------------------------------------------------------
	@Column(name = "BOOK_ORDER_ID", nullable = false)
	private Integer bookOrderId;

	@Column(name = "BOOK_ID", nullable = false)
	private Integer bookId;

	// ----------------------------------------------------------------------
	// CONSTRUCTORS
	// ----------------------------------------------------------------------
	public BookOrderItemJpaRecordKey() {
		super();
	}

	public BookOrderItemJpaRecordKey(Integer bookOrderId, Integer bookId) {
		super();
		this.bookOrderId = bookOrderId;
		this.bookId = bookId;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR KEY FIELDS
	// ----------------------------------------------------------------------
	public void setBookOrderId(Integer value) {
		this.bookOrderId = value;
	}

	public Integer getBookOrderId() {
		return this.bookOrderId;
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
		BookOrderItemJpaRecordKey other = (BookOrderItemJpaRecordKey) obj;
		// --- Attribute bookOrderId
		if (bookOrderId == null) {
			if (other.bookOrderId != null)
				return false;
		} else if (!bookOrderId.equals(other.bookOrderId))
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

		// --- Attribute bookOrderId
		result = prime * result + ((bookOrderId == null) ? 0 : bookOrderId.hashCode());
		// --- Attribute bookId
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());

		return result;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(bookOrderId);
		sb.append("|");
		sb.append(bookId);
		return sb.toString();
	}
}
