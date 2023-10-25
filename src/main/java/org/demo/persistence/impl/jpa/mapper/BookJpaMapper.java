package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.BookRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.BookJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class BookJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public BookJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'BookJpaRecord' to 'BookRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public BookRecord mapEntityToRecord(BookJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		BookRecord record = map(entity, BookRecord.class);

		return record;
	}

	/**
	 * Mapping from 'BookRecord' to 'BookJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public BookJpaRecord mapRecordToEntity(BookRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, BookJpaRecord.class);
	}

	/**
	 * Mapping from record 'BookRecord' to entity 'BookJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(BookRecord record, BookJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}