/**
 * 
 */
package eu.heth.dao.impl;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.heth.dao.MealDao;
import eu.heth.entity.MealEntity;
import eu.heth.exception.SystemException;

/**
 * @author tomey
 *
 */
public class MealMongoDao extends AbstractMongoDao implements MealDao {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(MealMongoDao.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.heth.dao.MealDao#findByCodeRegistryAndFilter(org.bson.conversions.Bson)
	 */
	@Override
	public List<MealEntity> findByCodeRegistryAndFilter(Bson bsonFilter) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#getCount(org.bson.conversions.Bson)
	 */
	@Override
	public int getCount(Bson bsonFilter) throws SystemException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#testConnexion()
	 */
	@Override
	public boolean testConnexion() throws SystemException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#saveOneDocument(eu.heth.entity.MealEntity)
	 */
	@Override
	public String saveOneDocument(MealEntity meal) throws SystemException {

		// TODO transform MealEntity to document
		Document document = toDocument(meal);

		return saveOneDocument(document, getKeyCollectionName());
	}

	private Document toDocument(MealEntity meal) {
		// TODO Auto-generated method stub
		Document doc = new Document();
		doc.append("cooker", "tdurand");

		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#dropCollection()
	 */
	@Override
	public void dropCollection() throws SystemException {
		dropCollection(getKeyCollectionName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#getTotalCount()
	 */
	@Override
	public long getTotalCount() throws SystemException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#getTheFirstDocument()
	 */
	@Override
	public MealEntity getTheFirstDocument() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#findById(java.lang.String)
	 */
	@Override
	public MealEntity findById(String uid) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#findDocumentById(java.lang.String)
	 */
	@Override
	public MealEntity findDocumentById(String uid) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#update(java.lang.String, eu.heth.entity.MealEntity)
	 */
	@Override
	public void update(String uid, MealEntity meal) throws SystemException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.impl.AbstractMongoDao#getKeyCollectionName()
	 */
	@Override
	protected String getKeyCollectionName() {
		return "meal";
	}
}
