package org.demo.persistence;

import java.util.List;

import org.demo.data.record.SynopsisRecord;

/**
 * Persistence Interface for SynopsisRecord.
 */
public interface SynopsisPersistence {

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * 
	 * @param bookId
	 * @return entity
	 */
	SynopsisRecord findById(Integer bookId);

	/**
	 * Finds all entities.
	 * 
	 * @return all entities
	 */
	List<SynopsisRecord> findAll();

	/**
	 * Counts all the records present in the database
	 * 
	 * @return
	 */
	public long countAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * 
	 * @param entity
	 * @return entity
	 */
	SynopsisRecord save(SynopsisRecord entity);

	/**
	 * Updates the given entity in the database
	 * 
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not
	 *         updated
	 */
	boolean update(SynopsisRecord entity);

	/**
	 * Creates the given entity in the database
	 * 
	 * @param entity
	 * @return
	 */
	SynopsisRecord create(SynopsisRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * 
	 * @param bookId
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean deleteById(Integer bookId);

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * 
	 * @param the
	 *            entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean delete(SynopsisRecord entity);

	/**
	 * Returns true if an entity exists with the given Id / Primary Key
	 * 
	 * @param bookId
	 * @return
	 */
	public boolean exists(Integer bookId);

	/**
	 * Returns true if the given entity exists
	 * 
	 * @param entity
	 * @return
	 */
	public boolean exists(SynopsisRecord entity);

}
