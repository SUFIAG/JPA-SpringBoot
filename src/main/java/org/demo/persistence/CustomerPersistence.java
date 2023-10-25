package org.demo.persistence;

import java.util.List;

import org.demo.data.record.CustomerRecord;

/**
 * Persistence Interface for CustomerRecord.
 */
public interface CustomerPersistence {

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * 
	 * @param code
	 * @return entity
	 */
	CustomerRecord findById(String code);

	/**
	 * Finds all entities.
	 * 
	 * @return all entities
	 */
	List<CustomerRecord> findAll();

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
	CustomerRecord save(CustomerRecord entity);

	/**
	 * Updates the given entity in the database
	 * 
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not
	 *         updated
	 */
	boolean update(CustomerRecord entity);

	/**
	 * Creates the given entity in the database
	 * 
	 * @param entity
	 * @return
	 */
	CustomerRecord create(CustomerRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * 
	 * @param code
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean deleteById(String code);

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * 
	 * @param the
	 *            entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean delete(CustomerRecord entity);

	/**
	 * Returns true if an entity exists with the given Id / Primary Key
	 * 
	 * @param code
	 * @return
	 */
	public boolean exists(String code);

	/**
	 * Returns true if the given entity exists
	 * 
	 * @param entity
	 * @return
	 */
	public boolean exists(CustomerRecord entity);

}
