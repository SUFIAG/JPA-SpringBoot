package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.ReviewRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.ReviewJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class ReviewJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public ReviewJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'ReviewJpaRecord' to 'ReviewRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public ReviewRecord mapEntityToRecord(ReviewJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		ReviewRecord record = map(entity, ReviewRecord.class);

		return record;
	}

	/**
	 * Mapping from 'ReviewRecord' to 'ReviewJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public ReviewJpaRecord mapRecordToEntity(ReviewRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, ReviewJpaRecord.class);
	}

	/**
	 * Mapping from record 'ReviewRecord' to entity 'ReviewJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(ReviewRecord record, ReviewJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}