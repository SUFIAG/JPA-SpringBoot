package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * Persistent class for "BookOrderItem" entity stored in table "BOOK_ORDER_ITEM"
 * <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "BOOK_ORDER_ITEM", schema = "ROOT")
// Define named queries here
@NamedQueries({
		@NamedQuery(name = "BookOrderItemJpaRecord.countAll", query = "SELECT COUNT(x) FROM BookOrderItemJpaRecord x"),
		@NamedQuery(name = "BookOrderItemJpaRecord.countById", query = "SELECT COUNT(x) FROM BookOrderItemJpaRecord x WHERE x.compositePrimaryKey.bookOrderId = ?1  AND x.compositePrimaryKey.bookId = ?2 ") })
public class BookOrderItemJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	@EmbeddedId
	private BookOrderItemJpaRecordKey compositePrimaryKey;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;

	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public BookOrderItemJpaRecord() {
		super();
		this.compositePrimaryKey = new BookOrderItemJpaRecordKey();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE COMPOSITE KEY
	// ----------------------------------------------------------------------
	public void setBookOrderId(Integer bookOrderId) {
		this.compositePrimaryKey.setBookOrderId(bookOrderId);
	}

	public Integer getBookOrderId() {
		return this.compositePrimaryKey.getBookOrderId();
	}

	public void setBookId(Integer bookId) {
		this.compositePrimaryKey.setBookId(bookId);
	}

	public Integer getBookId() {
		return this.compositePrimaryKey.getBookId();
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : QUANTITY ( INTEGER )
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	// --- DATABASE MAPPING : PRICE ( DECIMAL )
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if (compositePrimaryKey != null) {
			sb.append(compositePrimaryKey.toString());
		} else {
			sb.append("(null-key)");
		}
		sb.append("]:");
		sb.append(quantity);
		sb.append("|");
		sb.append(price);
		return sb.toString();
	}

}
