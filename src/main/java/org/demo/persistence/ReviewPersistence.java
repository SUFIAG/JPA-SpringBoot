package org.demo.persistence;

import java.util.List;

import org.demo.data.record.ReviewRecord;

/**
 * Persistence Interface for ReviewRecord.
 */
public interface ReviewPersistence {

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * 
	 * @param customerCode
	 * @param bookId
	 * @return entity
	 */
	ReviewRecord findById(String customerCode, Integer bookId);

	/**
	 * Finds all entities.
	 * 
	 * @return all entities
	 */
	List<ReviewRecord> findAll();

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
	ReviewRecord save(ReviewRecord entity);

	/**
	 * Updates the given entity in the database
	 * 
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not
	 *         updated
	 */
	boolean update(ReviewRecord entity);

	/**
	 * Creates the given entity in the database
	 * 
	 * @param entity
	 * @return
	 */
	ReviewRecord create(ReviewRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * 
	 * @param customerCode
	 * @param bookId
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean deleteById(String customerCode, Integer bookId);

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * 
	 * @param the
	 *            entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean delete(ReviewRecord entity);

	/**
	 * Returns true if an entity exists with the given Id / Primary Key
	 * 
	 * @param customerCode
	 * @param bookId
	 * @return
	 */
	public boolean exists(String customerCode, Integer bookId);

	/**
	 * Returns true if the given entity exists
	 * 
	 * @param entity
	 * @return
	 */
	public boolean exists(ReviewRecord entity);

}
