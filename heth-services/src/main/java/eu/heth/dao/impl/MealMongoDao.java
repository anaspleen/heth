/**
 * 
 */
package eu.heth.dao.impl;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoCollection;

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
		//
		// return saveOneDocument(document, getKeyCollectionName());

		// CodecRegistry pojoCodecRegistry =
		// fromRegistries(MongoClient.getDefaultCodecRegistry(),
		// fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		//
		//
		// MongoClient mongoClient = new MongoClient("localhost",
		// MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

		// https://mvnrepository.com/artifact/org.springframework.data/spring-data-mongodb-parent/2.1.0.RELEASE
		// https://www.baeldung.com/spring-data-mongodb-tutorial
		// https://docs.spring.io/spring-data/data-document/docs/current/reference/html/

		String res = "";
		CapMongoClient client = null;

		try {
			client = getClient();
			MongoCollection<Document> coll = getDatabase(client).getCollection(getCollectionName());
			coll.insertOne(document);

			res = document.get(TAG_ID).toString();
		} catch (Exception e) {
			LOG.error("Error on persisting document", e);
			throw e;
		} finally {
			if (client != null) {
				releaseClient(client);
			}
		}

		return res;

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
