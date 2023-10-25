package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.EmployeeGroupRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.EmployeeGroupJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class EmployeeGroupJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public EmployeeGroupJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'EmployeeGroupJpaRecord' to 'EmployeeGroupRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public EmployeeGroupRecord mapEntityToRecord(EmployeeGroupJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		EmployeeGroupRecord record = map(entity, EmployeeGroupRecord.class);

		return record;
	}

	/**
	 * Mapping from 'EmployeeGroupRecord' to 'EmployeeGroupJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public EmployeeGroupJpaRecord mapRecordToEntity(EmployeeGroupRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, EmployeeGroupJpaRecord.class);
	}

	/**
	 * Mapping from record 'EmployeeGroupRecord' to entity
	 * 'EmployeeGroupJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(EmployeeGroupRecord record, EmployeeGroupJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}