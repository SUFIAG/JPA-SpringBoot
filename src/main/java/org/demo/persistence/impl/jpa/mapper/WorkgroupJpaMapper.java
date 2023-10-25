package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.WorkgroupRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.WorkgroupJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class WorkgroupJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public WorkgroupJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'WorkgroupJpaRecord' to 'WorkgroupRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public WorkgroupRecord mapEntityToRecord(WorkgroupJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		WorkgroupRecord record = map(entity, WorkgroupRecord.class);

		return record;
	}

	/**
	 * Mapping from 'WorkgroupRecord' to 'WorkgroupJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public WorkgroupJpaRecord mapRecordToEntity(WorkgroupRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, WorkgroupJpaRecord.class);
	}

	/**
	 * Mapping from record 'WorkgroupRecord' to entity 'WorkgroupJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(WorkgroupRecord record, WorkgroupJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}