/**
 * 
 */
package eu.heth.entity;

import java.io.Serializable;

/**
 * @author tomey
 *
 */
public class MealEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** the name */
	private String name;

	/** the cooker */
	private String cooker;

	/**
	 * Default const
	 */
	public MealEntity() {
		// NTD
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cooker
	 */
	public String getCooker() {
		return cooker;
	}

	/**
	 * @param cooker
	 *            the cooker to set
	 */
	public void setCooker(String cooker) {
		this.cooker = cooker;
	}
}
