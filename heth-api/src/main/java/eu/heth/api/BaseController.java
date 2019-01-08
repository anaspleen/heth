/**
 * 
 */
package eu.heth.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import eu.heth.configuration.ApplicationConfig;

/**
 * Common class for Controller
 * 
 * @author tomey
 *
 */
@RequestMapping(path = "/api")
public abstract class BaseController {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(MealController.class);

	/** the context */
	private AbstractApplicationContext context;

	/**
	 * 
	 * @return the context
	 */
	protected AbstractApplicationContext getContext() {

		if (context == null) {
			initializeContext();
		}

		return context;
	}

	/**
	 * to initialize context once
	 */
	private synchronized void initializeContext() {
		LOG.info("Context initialized");
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}
}
