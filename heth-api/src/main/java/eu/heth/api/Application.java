/**
 * 
 */
package eu.heth.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class
 * 
 * @author tomey
 *
 */
@SpringBootApplication
public class Application {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	/**
	 * The main
	 * 
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		LOG.info("In Main");
		SpringApplication.run(Application.class, args);
		LOG.info("SpringApplication running");
	}
}
