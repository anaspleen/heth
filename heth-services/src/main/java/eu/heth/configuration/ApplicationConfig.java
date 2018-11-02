/**
 * 
 */
package eu.heth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * To manage Mongo stuff
 * 
 * http://www.technicalkeeda.com/spring-tutorials/spring-4-mongodb-repository-example
 * 
 * @author tomey
 *
 */
@Configuration
@ComponentScan(basePackages = "eu.heth")
@EnableMongoRepositories({ "eu.heth.dao.repositories" })
public class ApplicationConfig {

	/**
	 * The properties
	 */
	@Autowired
	@Qualifier("configProperties")
	private ConfigProperties configProperties;

	/**
	 * To manage factory
	 * 
	 * @return the factory
	 * @throws Exception
	 *             problem
	 */
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {

		MongoClient mongoClient = new MongoClient(configProperties.getMongodbHost(), configProperties.getMongodbPort());
		UserCredentials userCredentials = new UserCredentials("", "");
		// return new SimpleMongoDbFactory(mongoClient, "technicalkeeda",
		// userCredentials);

		return new SimpleMongoDbFactory(mongoClient, configProperties.getMongodbDatabase());

	}

	/**
	 * To get mongo template
	 * 
	 * @return mongo template
	 * @throws Exception
	 *             problem
	 */
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
}
