/**
 * 
 */
package eu.heth.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.heth.bean.Meal;
import eu.heth.bean.MealBean;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.service.MealService;

/**
 * Controller for meal
 * 
 * @author tomey
 *
 */
@RestController
public class MealController extends BaseController {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(MealController.class);

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(path = "/meal/get", method = RequestMethod.GET)
	public List<Meal> getMeal(@RequestParam(value = "cooker", defaultValue = "World") String cooker) {

		MealService mealService = getMealService();

		List<Meal> meals = new ArrayList<Meal>();

		// meals.add(new MealBean("ddd","dd"));
		// meals.add(new MealBean("ddds","dds"));

		// FIXME method not found on repository why ?
		try {
			meals = mealService.getMealsFromCooker(cooker);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(meals);

		return meals;
	}

	@RequestMapping(path = "/meal/save", method = RequestMethod.GET)
	public Meal saveMeal(@RequestParam(value = "cooker", defaultValue = "World") String cooker) {

		MealService mealService = getMealService();

		String name = "APICook_" + System.currentTimeMillis();
		try {
			mealService.saveMealsFromCooker(name, cooker);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new MealBean(name, String.format(template, cooker));
	}

	/**
	 * 
	 * @return the service
	 */
	private MealService getMealService() {
		return (MealService) getContext().getBean("mealService");
	}
}
