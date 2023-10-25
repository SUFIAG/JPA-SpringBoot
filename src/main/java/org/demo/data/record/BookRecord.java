package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.math.BigDecimal;

/**
 * Java bean for entity "BOOK" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class BookRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer id; // Integer // Id or Primary Key

	@NotNull
	private Integer publisherId; // Integer
	@NotNull
	private Integer authorId; // Integer
	@NotNull
	@Size(min = 1, max = 13)
	private String isbn; // String
	@Size(max = 160)
	private String title; // String

	private BigDecimal price; // BigDecimal

	private Integer quantity; // Integer

	private Integer discount; // Integer

	private Short availability; // Short

	private Short bestSeller; // Short

	/**
	 * Default constructor
	 */
	public BookRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "id" field value This field is mapped on the database column "ID"
	 * ( type "INTEGER", NotNull : true )
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the "id" field value This field is mapped on the database column "ID"
	 * ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	/**
	 * Set the "publisherId" field value This field is mapped on the database
	 * column "PUBLISHER_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @param publisherId
	 */
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	/**
	 * Get the "publisherId" field value This field is mapped on the database
	 * column "PUBLISHER_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getPublisherId() {
		return this.publisherId;
	}

	/**
	 * Set the "authorId" field value This field is mapped on the database
	 * column "AUTHOR_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @param authorId
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * Get the "authorId" field value This field is mapped on the database
	 * column "AUTHOR_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getAuthorId() {
		return this.authorId;
	}

	/**
	 * Set the "isbn" field value This field is mapped on the database column
	 * "ISBN" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Get the "isbn" field value This field is mapped on the database column
	 * "ISBN" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getIsbn() {
		return this.isbn;
	}

	/**
	 * Set the "title" field value This field is mapped on the database column
	 * "TITLE" ( type "VARCHAR", NotNull : false )
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the "title" field value This field is mapped on the database column
	 * "TITLE" ( type "VARCHAR", NotNull : false )
	 * 
	 * @return the field value
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Set the "price" field value This field is mapped on the database column
	 * "PRICE" ( type "DECIMAL", NotNull : false )
	 * 
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Get the "price" field value This field is mapped on the database column
	 * "PRICE" ( type "DECIMAL", NotNull : false )
	 * 
	 * @return the field value
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * Set the "quantity" field value This field is mapped on the database
	 * column "QUANTITY" ( type "INTEGER", NotNull : false )
	 * 
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the "quantity" field value This field is mapped on the database
	 * column "QUANTITY" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * Set the "discount" field value This field is mapped on the database
	 * column "DISCOUNT" ( type "INTEGER", NotNull : false )
	 * 
	 * @param discount
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	/**
	 * Get the "discount" field value This field is mapped on the database
	 * column "DISCOUNT" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getDiscount() {
		return this.discount;
	}

	/**
	 * Set the "availability" field value This field is mapped on the database
	 * column "AVAILABILITY" ( type "SMALLINT", NotNull : false )
	 * 
	 * @param availability
	 */
	public void setAvailability(Short availability) {
		this.availability = availability;
	}

	/**
	 * Get the "availability" field value This field is mapped on the database
	 * column "AVAILABILITY" ( type "SMALLINT", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Short getAvailability() {
		return this.availability;
	}

	/**
	 * Set the "bestSeller" field value This field is mapped on the database
	 * column "BEST_SELLER" ( type "SMALLINT", NotNull : false )
	 * 
	 * @param bestSeller
	 */
	public void setBestSeller(Short bestSeller) {
		this.bestSeller = bestSeller;
	}

	/**
	 * Get the "bestSeller" field value This field is mapped on the database
	 * column "BEST_SELLER" ( type "SMALLINT", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Short getBestSeller() {
		return this.bestSeller;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append("|");
		sb.append(publisherId);
		sb.append("|");
		sb.append(authorId);
		sb.append("|");
		sb.append(isbn);
		sb.append("|");
		sb.append(title);
		sb.append("|");
		sb.append(price);
		sb.append("|");
		sb.append(quantity);
		sb.append("|");
		sb.append(discount);
		sb.append("|");
		sb.append(availability);
		sb.append("|");
		sb.append(bestSeller);
		return sb.toString();
	}

}
