/**
 * 
 */
package eu.heth.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.heth.configuration.ApplicationConfig;
import eu.heth.service.MealService;

/**
 * The Class CapCommonTestCase.
 *
 * @author tcaiati
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public abstract class HethCommonTestCase {

	/** The Constant LOGIN_TEST. */
	protected static final String LOGIN_TEST = "loginTest";

	/** the context */
	private AbstractApplicationContext context;

	/**
	 * Default const.
	 *
	 * @throws Exception
	 *             exception
	 */
	public HethCommonTestCase() throws Exception {
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}

	/**
	 * before each test.
	 *
	 * @throws Exception
	 *             exception
	 */
	@Before
	public void setUp() throws Exception {

		// drop, create, insert configuration
		// dropDatas();
	}

	/**
	 * After each test.
	 *
	 * @throws Exception
	 *             exception
	 */
	@After
	public void tearDown() throws Exception {
		//
	}

	public MealService getMealService() {
		return (MealService) context.getBean("mealService");
	}
}
