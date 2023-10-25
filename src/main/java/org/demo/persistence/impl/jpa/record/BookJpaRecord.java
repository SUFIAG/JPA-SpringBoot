package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * Persistent class for "Book" entity stored in table "BOOK" <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "BOOK", schema = "ROOT")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "BookJpaRecord.countAll", query = "SELECT COUNT(x) FROM BookJpaRecord x"),
		@NamedQuery(name = "BookJpaRecord.countById", query = "SELECT COUNT(x) FROM BookJpaRecord x WHERE x.id = ?1 ") })
public class BookJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "PUBLISHER_ID", nullable = false)
	private Integer publisherId; // Foreign Key

	@Column(name = "AUTHOR_ID", nullable = false)
	private Integer authorId; // Foreign Key

	@Column(name = "ISBN", nullable = false, length = 13)
	private String isbn;

	@Column(name = "TITLE", length = 160)
	private String title;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "DISCOUNT")
	private Integer discount;

	@Column(name = "AVAILABILITY")
	private Short availability;

	@Column(name = "BEST_SELLER")
	private Short bestSeller;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public BookJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : PUBLISHER_ID ( INTEGER )
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Integer getPublisherId() {
		return this.publisherId;
	}

	// --- DATABASE MAPPING : AUTHOR_ID ( INTEGER )
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getAuthorId() {
		return this.authorId;
	}

	// --- DATABASE MAPPING : ISBN ( VARCHAR )
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return this.isbn;
	}

	// --- DATABASE MAPPING : TITLE ( VARCHAR )
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// --- DATABASE MAPPING : PRICE ( DECIMAL )
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	// --- DATABASE MAPPING : QUANTITY ( INTEGER )
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	// --- DATABASE MAPPING : DISCOUNT ( INTEGER )
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	// --- DATABASE MAPPING : AVAILABILITY ( SMALLINT )
	public void setAvailability(Short availability) {
		this.availability = availability;
	}

	public Short getAvailability() {
		return this.availability;
	}

	// --- DATABASE MAPPING : BEST_SELLER ( SMALLINT )
	public void setBestSeller(Short bestSeller) {
		this.bestSeller = bestSeller;
	}

	public Short getBestSeller() {
		return this.bestSeller;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
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
