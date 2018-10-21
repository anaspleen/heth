/**
 * 
 */
package eu.heth.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.heth.bean.Meal;
import eu.heth.dao.repositories.MealEntityRepository;
import eu.heth.entity.MealEntity;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.SystemException;
import eu.heth.service.MealService;

/**
 * @author tomey
 *
 */
@Service("mealService")
public class MealServiceImpl implements MealService {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(MealServiceImpl.class);

	/** the meal */
	@Autowired
	private MealEntityRepository mealEntityRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.service.MealService#getMealsFromCooker(java.lang.String)
	 */
	@Override
	public List<Meal> getMealsFromCooker(String cooker) throws ApplicationException, SystemException {
		// TODO Auto-generated method stub
		
		// http://www.technicalkeeda.com/spring-tutorials/spring-4-mongodb-repository-example

		mealEntityRepository.save(new MealEntity("first", "cooker"));

		return null;
	}

	/**
	 * @return the mealEntityRepository
	 */
	public MealEntityRepository getMealEntityRepository() {
		return mealEntityRepository;
	}

	/**
	 * @param mealEntityRepository
	 *            the mealEntityRepository to set
	 */
	public void setMealEntityRepository(MealEntityRepository mealEntityRepository) {
		this.mealEntityRepository = mealEntityRepository;
	}
}
