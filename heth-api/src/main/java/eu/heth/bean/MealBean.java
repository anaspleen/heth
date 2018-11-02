/**
 * 
 */
package eu.heth.bean;

import java.io.Serializable;

/**
 * @author tomey
 *
 */
public class MealBean implements Meal, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** the login cooler */
	private String cooker;

	/** the name */
	private String name;

	/**
	 * Default const
	 * 
	 * @param cooker
	 *            the cooker
	 * @param name
	 *            the name
	 */
	public MealBean(String cooker, String name) {
		this.cooker = cooker;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.bean.Meal#getCooker()
	 */
	@Override
	public String getCooker() {
		return cooker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.heth.bean.Meal#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param cooker
	 *            the cooker to set
	 */
	public void setCooker(String cooker) {
		this.cooker = cooker;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
