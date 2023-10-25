package org.demo.persistence;

import java.util.List;

import org.demo.data.record.EmployeeGroupRecord;

/**
 * Persistence Interface for EmployeeGroupRecord.
 */
public interface EmployeeGroupPersistence {

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * 
	 * @param employeeCode
	 * @param groupId
	 * @return entity
	 */
	EmployeeGroupRecord findById(String employeeCode, Short groupId);

	/**
	 * Finds all entities.
	 * 
	 * @return all entities
	 */
	List<EmployeeGroupRecord> findAll();

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
	EmployeeGroupRecord save(EmployeeGroupRecord entity);

	/**
	 * Updates the given entity in the database
	 * 
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not
	 *         updated
	 */
	boolean update(EmployeeGroupRecord entity);

	/**
	 * Creates the given entity in the database
	 * 
	 * @param entity
	 * @return
	 */
	EmployeeGroupRecord create(EmployeeGroupRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * 
	 * @param employeeCode
	 * @param groupId
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean deleteById(String employeeCode, Short groupId);

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * 
	 * @param the
	 *            entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not
	 *         deleted
	 */
	boolean delete(EmployeeGroupRecord entity);

	/**
	 * Returns true if an entity exists with the given Id / Primary Key
	 * 
	 * @param employeeCode
	 * @param groupId
	 * @return
	 */
	public boolean exists(String employeeCode, Short groupId);

	/**
	 * Returns true if the given entity exists
	 * 
	 * @param entity
	 * @return
	 */
	public boolean exists(EmployeeGroupRecord entity);

}
