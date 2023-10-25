package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.util.Date;

/**
 * Java bean for entity "BOOK_ORDER" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class BookOrderRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer id; // Integer // Id or Primary Key

	@NotNull
	@Size(min = 1, max = 3)
	private String shopCode; // String
	@NotNull
	@Size(min = 1, max = 5)
	private String customerCode; // String
	@NotNull
	@Size(min = 1, max = 4)
	private String employeeCode; // String

	private Date date; // Date

	private Integer state; // Integer

	/**
	 * Default constructor
	 */
	public BookOrderRecord() {
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
	 * Set the "shopCode" field value This field is mapped on the database
	 * column "SHOP_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param shopCode
	 */
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	/**
	 * Get the "shopCode" field value This field is mapped on the database
	 * column "SHOP_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getShopCode() {
		return this.shopCode;
	}

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
	 * Set the "employeeCode" field value This field is mapped on the database
	 * column "EMPLOYEE_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @param employeeCode
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * Get the "employeeCode" field value This field is mapped on the database
	 * column "EMPLOYEE_CODE" ( type "VARCHAR", NotNull : true )
	 * 
	 * @return the field value
	 */
	public String getEmployeeCode() {
		return this.employeeCode;
	}

	/**
	 * Set the "date" field value This field is mapped on the database column
	 * "DATE" ( type "DATE", NotNull : false )
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Get the "date" field value This field is mapped on the database column
	 * "DATE" ( type "DATE", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Set the "state" field value This field is mapped on the database column
	 * "STATE" ( type "INTEGER", NotNull : false )
	 * 
	 * @param state
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * Get the "state" field value This field is mapped on the database column
	 * "STATE" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getState() {
		return this.state;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append("|");
		sb.append(shopCode);
		sb.append("|");
		sb.append(customerCode);
		sb.append("|");
		sb.append(employeeCode);
		sb.append("|");
		sb.append(date);
		sb.append("|");
		sb.append(state);
		return sb.toString();
	}

}
