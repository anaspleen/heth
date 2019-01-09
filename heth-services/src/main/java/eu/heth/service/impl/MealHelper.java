/**
 * 
 */
package eu.heth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import eu.heth.bean.MealBean;
import eu.heth.entity.MealEntity;

/**
 * Utils class to manage group beans / entities
 * 
 * @author tomey
 *
 */
public final class MealHelper {

	/** logger */
	private static final Logger LOG = LoggerFactory.getLogger(MealHelper.class);

	/**
	 * Default const
	 */
	private MealHelper() {
		// RAF
	}

	/**
	 * To transform entity to bean
	 * 
	 * @param entity
	 *            entity
	 * @return bean
	 */
	public static MealBean toBean(MealEntity entity) {

		MealBean bean = null;

		if (entity != null) {
			try {
				bean = new MealBean();
				BeanUtils.copyProperties(entity, bean);

			} catch (Exception e) {
				LOG.error("Error on creating meal bean", e);
			}
		}

		return bean;
	}
}
