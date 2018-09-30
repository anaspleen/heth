/**
 * 
 */
package eu.heth.dao.impl;

import java.util.List;
import java.util.Properties;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import eu.heth.dao.utils.PropertiesConstantes;
import eu.heth.exception.SystemException;

/**
 * To manage connexion to MongoDB
 * 
 * @author tcaiati
 *
 */
public abstract class AbstractMongoDao {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractMongoDao.class);

	/** The properties. */
	private Properties daoProperties;

	/** tags id */
	public static final String TAG_ID = "_id";

	/**
	 * Little dirty class to get databaseName form URI, example :
	 * PropertiesConstantes.MONGODB_COLLECTION.
	 * 
	 * Example : getting databaseName with simple URI :
	 * mongodb://192.168.1.124:27017/recette => extract "recette"
	 * 
	 * @author tomey
	 *
	 */
	public class CapMongoClient extends MongoClient {

		private String databaseName;

		public CapMongoClient() {
			super();
		}

		public CapMongoClient(MongoClientURI uri) {
			super(uri);
		}

		/**
		 * @return the databaseName
		 */
		public String getDatabaseName() {
			return databaseName;
		}

		/**
		 * @param databaseName
		 *            the databaseName to set
		 */
		public void setDatabaseName(String databaseName) {
			this.databaseName = databaseName;
		}
	}

	/**
	 * @return client
	 */
	protected CapMongoClient getClient() {
		MongoClientURI uri = new MongoClientURI(getDatabaseURL());
		CapMongoClient client = new CapMongoClient(uri);
		client.setDatabaseName(uri.getDatabase());
		return client;
	}

	/**
	 * @return database
	 */
	protected MongoDatabase getDatabase(CapMongoClient client) {
		MongoDatabase database = client.getDatabase(client.getDatabaseName());
		return database;
	}

	/**
	 * release client
	 */
	protected void releaseClient(CapMongoClient client) {
		try {
			client.close();
		} catch (Exception e) {
			LOG.error("Cannot close connexion", e);
		}
	}

	/**
	 * @return the databaseURL
	 */
	public String getDatabaseURL() {
		return getDaoProperties().getProperty(PropertiesConstantes.MONGODB_URI);
	}

	/**
	 * 
	 * @return the collection name to use
	 */
	protected String getCollectionName() {
		return getDaoProperties().getProperty(getKeyCollectionName());
	}

	/**
	 * 
	 * @return the key of the property whose contains collection name, example :
	 *         spark.mongodb.output.collection
	 */
	protected abstract String getKeyCollectionName();

	/**
	 * @return the daoProperties
	 */
	public Properties getDaoProperties() {
		return daoProperties;
	}

	/**
	 * @param daoProperties
	 *            the daoProperties to set
	 */
	public void setDaoProperties(Properties daoProperties) {
		this.daoProperties = daoProperties;
	}

	/**
	 * To save one document
	 * 
	 * @param document
	 *            the doc to save
	 * @param collectionName
	 *            the collection
	 * @return uid
	 * @throws SystemException
	 *             technical exception
	 */
	protected String saveOneDocument(Document document, String collectionName) throws SystemException {

		String res = "";
		CapMongoClient client = null;

		try {
			client = getClient();
			MongoCollection<Document> coll = getDatabase(client).getCollection(collectionName);
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

	/**
	 * To save X documents
	 * 
	 * @param documents
	 *            the docs to save
	 * @param collectionName
	 *            the collection
	 * @return number of document saved
	 * @throws SystemException
	 *             technical exception
	 */
	protected int saveManyDocuments(List<Document> documents, String collectionName) throws SystemException {

		int res = 0;

		CapMongoClient client = null;

		try {
			client = getClient();
			MongoCollection<Document> coll = getDatabase(client).getCollection(collectionName);
			coll.insertMany(documents);
			res = documents.size();
		} catch (Exception e) {
			LOG.error("Serious error", e);
			throw e;
		} finally {
			if (client != null) {
				releaseClient(client);
			}
		}

		return res;
	}

	/**
	 * To drop collection. Use in TestU only
	 * 
	 * @param collectionName
	 *            the collection
	 * @throws SystemException
	 *             technical exception
	 */
	protected void dropCollection(String collectionName) throws SystemException {
		CapMongoClient client = null;

		try {
			client = getClient();
			MongoCollection<Document> coll = getDatabase(client).getCollection(collectionName);
			coll.drop();
		} catch (Exception e) {
			LOG.error("Serious error", e);
			throw e;
		} finally {
			if (client != null) {
				releaseClient(client);
			}
		}
	}

	/**
	 * Get the count of the collection
	 * 
	 * @param collectionName
	 *            the collection
	 * @return the count
	 * @throws SystemException
	 *             error
	 */
	protected long getTotalCount(String collectionName) throws SystemException {

		long res = 0;
		CapMongoClient client = null;

		try {
			client = getClient();
			MongoCollection<Document> coll = getDatabase(client).getCollection(collectionName);
			res = coll.count();
		} catch (Exception e) {
			LOG.error("Serious error", e);
			throw e;
		} finally {
			if (client != null) {
				releaseClient(client);
			}
		}

		return res;
	}

	/**
	 * Get the first document of the collection
	 * 
	 * @param collectionName
	 *            the collection
	 * @return the first document
	 * @throws SystemException
	 *             error
	 */
	protected Document getTheFirstDocument(String collectionName) throws SystemException {
		Document res = null;
		CapMongoClient client = null;

		try {
			client = getClient();
			MongoCollection<Document> coll = getDatabase(client).getCollection(collectionName);
			res = coll.find() != null ? coll.find().first() : null;
		} catch (Exception e) {
			LOG.error("Serious error", e);
			throw e;
		} finally {
			if (client != null) {
				releaseClient(client);
			}
		}

		return res;
	}
}
