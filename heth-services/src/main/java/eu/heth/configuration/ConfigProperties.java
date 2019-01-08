/**
 * 
 */
package eu.heth.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * To manage properties of application
 * 
 * @author tomey
 *
 */
@Configuration
@PropertySource("file:${HETH_CONF_PATH}/heth.properties")
@Service("configProperties")
public class ConfigProperties {

	@Value("${mongodb.host}")
	private String mongodbHost;

	@Value("${mongodb.port}")
	private int mongodbPort;

	@Value("${mongodb.database}")
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
