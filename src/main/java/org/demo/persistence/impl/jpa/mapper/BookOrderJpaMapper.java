package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.BookOrderRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.BookOrderJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class BookOrderJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public BookOrderJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'BookOrderJpaRecord' to 'BookOrderRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public BookOrderRecord mapEntityToRecord(BookOrderJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		BookOrderRecord record = map(entity, BookOrderRecord.class);

		return record;
	}

	/**
	 * Mapping from 'BookOrderRecord' to 'BookOrderJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public BookOrderJpaRecord mapRecordToEntity(BookOrderRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, BookOrderJpaRecord.class);
	}

	/**
	 * Mapping from record 'BookOrderRecord' to entity 'BookOrderJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(BookOrderRecord record, BookOrderJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}