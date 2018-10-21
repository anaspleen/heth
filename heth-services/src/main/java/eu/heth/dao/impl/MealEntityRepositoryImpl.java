/**
 * 
 */
package eu.heth.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;

import eu.heth.dao.MealEntityRepositoryCustom;
import eu.heth.entity.MealEntity;

/**
 * @author tomey
 *
 */
public class MealEntityRepositoryImpl implements MealEntityRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public int updateMealEntity(String name, boolean displayAds) {
		Query query = new Query(Criteria.where("name").is(name));
		Update update = new Update();
		update.set("displayAds", displayAds);

		// WriteResult result = mongoTemplate.updateFirst(query, update,
		// MailEntity.class);

		UpdateResult result = mongoTemplate.updateFirst(query, update, MealEntity.class);

		if (result != null)
			// return result.getN();
			return 1;
		else
			return 0;
	}

}
