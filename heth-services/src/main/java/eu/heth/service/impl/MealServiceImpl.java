/**
 * 
 */
package eu.heth.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import eu.heth.bean.Meal;
import eu.heth.dao.repositories.MealEntityRepository;
import eu.heth.entity.MealEntity;
import eu.heth.exception.ApplicationException;
import eu.heth.exception.IdentifiedError;
import eu.heth.exception.SystemException;
import eu.heth.service.MealService;

/**
 * Impl of service
 * 
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

		LOG.debug("cooker : " + cooker);

		List<IdentifiedError> errors = new ArrayList<IdentifiedError>();

		if (StringUtils.isEmpty(cooker)) {
			errors.add(new IdentifiedError("error.meal.find.cooker.empty"));
		}

		// if error, throw it
		if (errors.size() > 0) {
			throw new ApplicationException(Arrays.asList(errors));
		}

		List<Meal> meals = new ArrayList<Meal>();

		System.out.println(mealEntityRepository);

		List<MealEntity> entities = mealEntityRepository.findByCooker(cooker);

		if (entities != null && entities.size() > 0) {
			for (MealEntity entity : entities) {
				meals.add(MealHelper.toBean(entity));
			}
		}

		return meals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.service.MealService#saveMealsFromCooker(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String saveMealsFromCooker(String name, String cooker) throws ApplicationException, SystemException {

		LOG.debug("In saveMealsFromCooker");

		MealEntity entityToSave = new MealEntity(name, cooker);
		GeoJsonPoint point = new GeoJsonPoint(5.4, 45.2);
		entityToSave.setLocation(point);

		MealEntity entity = mealEntityRepository.save(entityToSave);
		return entity.getId();
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
