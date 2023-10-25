package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for "EmployeeGroup" entity stored in table "EMPLOYEE_GROUP"
 * <br>
 * This class is a "record entity" without JPA links <br>
 *
 */
@Entity
@Table(name = "EMPLOYEE_GROUP", schema = "ROOT")
// Define named queries here
@NamedQueries({
		@NamedQuery(name = "EmployeeGroupJpaRecord.countAll", query = "SELECT COUNT(x) FROM EmployeeGroupJpaRecord x"),
		@NamedQuery(name = "EmployeeGroupJpaRecord.countById", query = "SELECT COUNT(x) FROM EmployeeGroupJpaRecord x WHERE x.compositePrimaryKey.employeeCode = ?1  AND x.compositePrimaryKey.groupId = ?2 ") })
public class EmployeeGroupJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	@EmbeddedId
	private EmployeeGroupJpaRecordKey compositePrimaryKey;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public EmployeeGroupJpaRecord() {
		super();
		this.compositePrimaryKey = new EmployeeGroupJpaRecordKey();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE COMPOSITE KEY
	// ----------------------------------------------------------------------
	public void setEmployeeCode(String employeeCode) {
		this.compositePrimaryKey.setEmployeeCode(employeeCode);
	}

	public String getEmployeeCode() {
		return this.compositePrimaryKey.getEmployeeCode();
	}

	public void setGroupId(Short groupId) {
		this.compositePrimaryKey.setGroupId(groupId);
	}

	public Short getGroupId() {
		return this.compositePrimaryKey.getGroupId();
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------

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
		return sb.toString();
	}

}
