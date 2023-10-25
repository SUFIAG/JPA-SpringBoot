package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * Java bean for entity "EMPLOYEE_GROUP" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 *
 */
public class EmployeeGroupRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 4)
	private String employeeCode; // String // Id or Primary Key
	@NotNull
	private Short groupId; // Short // Id or Primary Key

	/**
	 * Default constructor
	 */
	public EmployeeGroupRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
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
	 * Set the "groupId" field value This field is mapped on the database column
	 * "GROUP_ID" ( type "SMALLINT", NotNull : true )
	 * 
	 * @param groupId
	 */
	public void setGroupId(Short groupId) {
		this.groupId = groupId;
	}

	/**
	 * Get the "groupId" field value This field is mapped on the database column
	 * "GROUP_ID" ( type "SMALLINT", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Short getGroupId() {
		return this.groupId;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(employeeCode);
		sb.append("|");
		sb.append(groupId);
		return sb.toString();
	}

}
