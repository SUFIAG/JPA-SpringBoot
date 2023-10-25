package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.BadgeRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.BadgeJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class BadgeJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public BadgeJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'BadgeJpaRecord' to 'BadgeRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public BadgeRecord mapEntityToRecord(BadgeJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		BadgeRecord record = map(entity, BadgeRecord.class);

		return record;
	}

	/**
	 * Mapping from 'BadgeRecord' to 'BadgeJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public BadgeJpaRecord mapRecordToEntity(BadgeRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, BadgeJpaRecord.class);
	}

	/**
	 * Mapping from record 'BadgeRecord' to entity 'BadgeJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(BadgeRecord record, BadgeJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}