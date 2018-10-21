/**
 * 
 */
package eu.heth.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.heth.dao.MealDao;
import eu.heth.exception.SystemException;
import eu.heth.service.MealService;

/**
 * The Class CapCommonTestCase.
 *
 * @author tcaiati
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/moduleTest/globalAC.xml" })
public abstract class HethCommonTestCase {

	/** The Constant LOGIN_TEST. */
	protected static final String LOGIN_TEST = "loginTest";

	@Autowired
//	@Qualifier("mealDao")
	private MealDao mealDao;

	@Autowired
	@Qualifier("mealService")
	private MealService mealService;

	/**
	 * Default const.
	 *
	 * @throws Exception
	 *             exception
	 */
	public HethCommonTestCase() throws Exception {
		// NTD
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
		dropDatas();
	}

	private void dropDatas() throws SystemException {
		getMealDao().dropCollection();
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

	public MealDao getMealDao() {
		return mealDao;
	}

	public MealService getMealService() {
		return mealService;
	}
}
