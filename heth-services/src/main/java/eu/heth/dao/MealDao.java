/**
 * 
 */
package eu.heth.dao;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import eu.heth.entity.MealEntity;
import eu.heth.exception.SystemException;

/**
 * To manage DAO of Meals
 * 
 * @author tcaiati
 *
 */
public interface MealDao {

	/**
	 * Find logs with codecRegistry and bsonFilter
	 * 
	 * @param bsonFilter
	 *            the filter
	 * @return the logs found
	 * @throws SystemException
	 *             error
	 */
	List<MealEntity> findByCodeRegistryAndFilter(Bson bsonFilter) throws SystemException;

	/**
	 * Get the count
	 * 
	 * @param bsonFilter
	 *            filter
	 * @return the count
	 * @throws SystemException
	 *             error
	 */
	int getCount(Bson bsonFilter) throws SystemException;

	/**
	 * To test connexion to DB
	 * 
	 * @return true if DB is up
	 * @throws SystemException
	 *             error
	 */
	boolean testConnexion() throws SystemException;

	/**
	 * To save one document
	 * 
	 * @param document
	 *            the doc to save
	 * @param collectionName
	 *            the collection
	 * @return uid
	 * @throws UniqIDException
	 *             if uid yet exists
	 * @throws SystemException
	 *             technical exception
	 */
	String saveOneDocument(Document document) throws SystemException;

	/**
	 * To drop collection. Use in TestU only
	 * 
	 * @throws SystemException
	 *             technical exception
	 */
	void dropCollection() throws SystemException;

	/**
	 * Get the count of the collection
	 * 
	 * @return the count
	 * @throws SystemException
	 *             error
	 */
	long getTotalCount() throws SystemException;

	/**
	 * Get the first document of the collection
	 * 
	 * @return the first document
	 * @throws SystemException
	 *             error
	 */
	Document getTheFirstDocument() throws SystemException;

	/**
	 * Get the Log with uid
	 * 
	 * @param uid
	 *            the uid to find
	 * @return the log if found
	 * @throws SystemException
	 *             error
	 */
	MealEntity findById(String uid) throws SystemException;

	/**
	 * Get the Log with uid (with ObjectId)
	 * 
	 * @param uid
	 *            the uid to find (with ObjectId : 5b1e6439c17a9b590c8810bf)
	 * @return the log if found
	 * @throws SystemException
	 *             error
	 */
	Document findDocumentById(String uid) throws SystemException;

	/**
	 * To update a Document (with ObjectId)
	 * 
	 * @param uid
	 *            the uid (with ObjectId : 5b1e6439c17a9b590c8810bf)
	 * @param doc
	 *            the bson to update, example : Updates.addToSet("histories", added)
	 * @throws SystemException
	 *             error
	 */
	void update(String uid, Bson doc) throws SystemException;
}
