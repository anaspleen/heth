/**
 * 
 */
package eu.heth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * http://www.technicalkeeda.com/spring-tutorials/spring-4-mongodb-repository-example
 * 
 * @author tomey
 *
 */
@Configuration
//@Configuration
@PropertySource("classpath:heth.properties")
public class ConfigProperties {

	private String mongodbHost;
	private int mongodbPort;
	private String mongodbDatabase;

	/**
	 * @return the mongodbHost
	 */
	public String getMongodbHost() {
		return mongodbHost;
	}

	/**
	 * @param mongodbHost
	 *            the mongodbHost to set
	 */
	public void setMongodbHost(String mongodbHost) {
		this.mongodbHost = mongodbHost;
	}

	/**
	 * @return the mongodbPort
	 */
	public int getMongodbPort() {
		return mongodbPort;
	}

	/**
	 * @param mongodbPort
	 *            the mongodbPort to set
	 */
	public void setMongodbPort(int mongodbPort) {
		this.mongodbPort = mongodbPort;
	}

	/**
	 * @return the mongodbDatabase
	 */
	public String getMongodbDatabase() {
		return mongodbDatabase;
	}

	/**
	 * @param mongodbDatabase
	 *            the mongodbDatabase to set
	 */
	public void setMongodbDatabase(String mongodbDatabase) {
		this.mongodbDatabase = mongodbDatabase;
	}

}
