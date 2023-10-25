package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.CustomerRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.CustomerJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class CustomerJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public CustomerJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'CustomerJpaRecord' to 'CustomerRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public CustomerRecord mapEntityToRecord(CustomerJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		CustomerRecord record = map(entity, CustomerRecord.class);

		return record;
	}

	/**
	 * Mapping from 'CustomerRecord' to 'CustomerJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public CustomerJpaRecord mapRecordToEntity(CustomerRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, CustomerJpaRecord.class);
	}

	/**
	 * Mapping from record 'CustomerRecord' to entity 'CustomerJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(CustomerRecord record, CustomerJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}