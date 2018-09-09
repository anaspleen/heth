/**
 * 
 */
package eu.heth.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.bson.Document;
import org.bson.conversions.Bson;

import eu.heth.dao.MealDao;
import eu.heth.entity.MealEntity;
import eu.heth.exception.SystemException;

/**
 * @author tomey
 *
 */
public class MealMongoDao implements MealDao {

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
	 * @see eu.heth.dao.MealDao#saveOneDocument(org.bson.Document)
	 */
	@Override
	public String saveOneDocument(Document document) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#dropCollection()
	 */
	@Override
	public void dropCollection() throws SystemException {
		// TODO Auto-generated method stub

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
	public Document getTheFirstDocument() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#findById(java.lang.String)
	 */
	@Override
	public Log findById(String uid) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#findDocumentById(java.lang.String)
	 */
	@Override
	public Document findDocumentById(String uid) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.MealDao#update(java.lang.String, org.bson.conversions.Bson)
	 */
	@Override
	public void update(String uid, Bson doc) throws SystemException {
		// TODO Auto-generated method stub

	}

}
