/**
 * 
 */
package eu.heth.api;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.heth.bean.Cooker;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.service.CookerService;

/**
 * Controller for cooker
 * 
 * @author tomey
 *
 */
@RestController
public class CookerController extends BaseController {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(CookerController.class);

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(path = "/cooker/get", method = RequestMethod.GET)
	public Cooker getCookerByNickname(@RequestParam(value = "nickname") String nickname) {

		CookerService cookerService = getCookerService();

		Cooker cooker = null;

		try {
			cooker = cookerService.getCookerByNickname(nickname);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cooker;
	}

	// @RequestMapping(path = "/cooker/save", method = RequestMethod.GET)
	// public Meal saveCooker(@RequestParam(value = "cooker", defaultValue =
	// "World") String cooker) {
	//
	// CookerService mealService = getCookerService();
	//
	// String name = "APICook_" + System.currentTimeMillis();
	// try {
	// mealService.saveMealsFromCooker(name, cooker);
	// } catch (ApplicationException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SystemException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return new MealBean(name, String.format(template, cooker));
	// }

	/**
	 * 
	 * @return the service
	 */
	private CookerService getCookerService() {
		return (CookerService) getContext().getBean("cookerService");
	}
}
