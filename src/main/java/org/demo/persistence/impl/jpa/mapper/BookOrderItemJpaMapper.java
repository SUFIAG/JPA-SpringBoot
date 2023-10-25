package org.demo.persistence.impl.jpa.mapper;

import org.demo.persistence.impl.jpa.commons.AbstractServiceMapper;

import org.demo.data.record.BookOrderItemRecord; // "Neutral Record" class 
import org.demo.persistence.impl.jpa.record.BookOrderItemJpaRecord; // "JPA Entity" class 

/**
 * Mapping between entity beans and display beans.
 */
public class BookOrderItemJpaMapper extends AbstractServiceMapper {

	/**
	 * Constructor.
	 */
	public BookOrderItemJpaMapper() {
		super();
	}

	/**
	 * Mapping from 'BookOrderItemJpaRecord' to 'BookOrderItemRecord'
	 * 
	 * @param entity
	 *            the mapping input
	 */
	public BookOrderItemRecord mapEntityToRecord(BookOrderItemJpaRecord entity) {
		if (entity == null) {
			return null;
		}

		// --- Generic mapping
		BookOrderItemRecord record = map(entity, BookOrderItemRecord.class);

		return record;
	}

	/**
	 * Mapping from 'BookOrderItemRecord' to 'BookOrderItemJpaRecord'
	 * 
	 * @param record
	 *            the mapping input
	 * @return
	 */
	public BookOrderItemJpaRecord mapRecordToEntity(BookOrderItemRecord record) {
		if (record == null) {
			return null;
		}
		return map(record, BookOrderItemJpaRecord.class);
	}

	/**
	 * Mapping from record 'BookOrderItemRecord' to entity
	 * 'BookOrderItemJpaRecord'
	 * 
	 * @param record
	 * @param entity
	 */
	public void mapRecordToEntity(BookOrderItemRecord record, BookOrderItemJpaRecord entity) {
		if (record == null) {
			return;
		}

		// --- Generic mapping
		map(record, entity);
	}

}