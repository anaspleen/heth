/**
 * 
 */
package eu.heth.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.mongodb.MongoClient;

import eu.heth.entity.MealEntity;

/**
 * @author tomey
 *
 */
public class MongoApp {

	private static final Log log = LogFactory.getLog(MongoApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "database");
		

		mongoOps.dropCollection("mealEntity");
		
		mongoOps.insert(new MealEntity("Joe", "ch"));

//		mongoOps.finOn
		
		MealEntity mealFound = mongoOps.findOne(new Query(where("name").is("Joe")), MealEntity.class);
//		log.info(mealFound);
		System.out.println(mealFound);

	}
}
