/**
 * 
 */
package eu.heth.dao.repositories.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import eu.heth.dao.repositories.CookerEntityRepositoryCustom;
import eu.heth.entity.CookerEntity;

/**
 * The custom impl
 * 
 * @author tcaiati
 *
 */
public class CookerEntityRepositoryMongo implements CookerEntityRepositoryCustom {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(CookerEntityRepositoryMongo.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.dao.repositories.CookerEntityRepositoryCustom#
	 * findByLocationWithin(com.mongodb.client.model.geojson.Point,
	 * java.lang.String)
	 */
	@Override
	public List<CookerEntity> getCustom(String distance) {
		// TODO Auto-generated method stub

		// Query criteriaQuery = new Query(
		// new Criteria("name").is("Isaac").and("location").within(point,
		// "20km"));

		Query criteriaQuery = new Query(new Criteria("name").is("Isaac"));
		List<CookerEntity> result = getMongoTemplate().find(criteriaQuery, CookerEntity.class);

		return result;
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate
	 *            the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
