package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.SynopsisRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.SynopsisJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class SynopsisJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public SynopsisJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'SynopsisJpaRecord' to 'SynopsisRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public SynopsisRecord mapEntityToRecord(SynopsisJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		SynopsisRecord record = map(entity, SynopsisRecord.class);

		return record;
	}

	/**
	 * Mapping from 'SynopsisRecord' to 'SynopsisJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public SynopsisJpaRecord mapRecordToEntity(SynopsisRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, SynopsisJpaRecord.class);
	}

	/**
	 * Mapping from record 'SynopsisRecord' to entity 'SynopsisJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(SynopsisRecord record, SynopsisJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}