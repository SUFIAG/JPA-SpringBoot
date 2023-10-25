package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.math.BigDecimal;

/**
 * Java bean for entity "BOOK_ORDER_ITEM" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class BookOrderItemRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer bookOrderId; // Integer // Id or Primary Key
	@NotNull
	private Integer bookId; // Integer // Id or Primary Key

	@NotNull
	private Integer quantity; // Integer
	@NotNull
	private BigDecimal price; // BigDecimal

	/**
	 * Default constructor
	 */
	public BookOrderItemRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "bookOrderId" field value This field is mapped on the database
	 * column "BOOK_ORDER_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @param bookOrderId
	 */
	public void setBookOrderId(Integer bookOrderId) {
		this.bookOrderId = bookOrderId;
	}

	/**
	 * Get the "bookOrderId" field value This field is mapped on the database
	 * column "BOOK_ORDER_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getBookOrderId() {
		return this.bookOrderId;
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
	 * Set the "quantity" field value This field is mapped on the database
	 * column "QUANTITY" ( type "INTEGER", NotNull : true )
	 * 
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the "quantity" field value This field is mapped on the database
	 * column "QUANTITY" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * Set the "price" field value This field is mapped on the database column
	 * "PRICE" ( type "DECIMAL", NotNull : true )
	 * 
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Get the "price" field value This field is mapped on the database column
	 * "PRICE" ( type "DECIMAL", NotNull : true )
	 * 
	 * @return the field value
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(bookOrderId);
		sb.append("|");
		sb.append(bookId);
		sb.append("|");
		sb.append(quantity);
		sb.append("|");
		sb.append(price);
		return sb.toString();
	}

}
