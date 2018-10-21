/**
 * 
 */
package eu.heth.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import eu.heth.configuration.ApplicationConfig;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.service.MealService;

/**
 * @author tomey
 *
 */
public class MongoAnotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		MealService carService = (MealService) context.getBean("mealService");

		try {
			carService.getMealsFromCooker("test");
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
