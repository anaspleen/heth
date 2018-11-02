/**
 * 
 */
package eu.heth.api;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.heth.bean.Meal;
import eu.heth.bean.MealBean;
import eu.heth.configuration.ApplicationConfig;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.service.MealService;

/**
 * @author tomey
 *
 */
@RestController
public class MealController {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(MealController.class);

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/** the context */
	private AbstractApplicationContext context;
	//
	// @Autowired
	// @Qualifier("mealService")
	// private MealService mealService;

	@RequestMapping(path = "/meal/get", method = RequestMethod.GET)
	public Meal getMeal(@RequestParam(value = "name", defaultValue = "World") String name) {

		System.out.println("in greetinf meal");

		System.out.println("context initialized");

		MealService mealService = getMealService();

		try {
			mealService.getMealsFromCooker(name);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new MealBean(counter.incrementAndGet() + "", String.format(template, name));
	}
	
	@RequestMapping(path = "/meal/save", method = RequestMethod.GET)
	public Meal saveMeal(@RequestParam(value = "name", defaultValue = "World") String name) {

		System.out.println("in greetinf meal");

		System.out.println("context initialized");

		MealService mealService = getMealService();

		try {
			mealService.getMealsFromCooker(name);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new MealBean(counter.incrementAndGet() + "", String.format(template, name));
	}

	private MealService getMealService() {
		return (MealService) getContext().getBean("mealService");
	}

	private AbstractApplicationContext getContext() {

		// TODO get context from main ?

		if (context == null) {
			// TODO logger use log4j
			LOG.info("Context initialied");
			context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		}

		return context;
	}
}
