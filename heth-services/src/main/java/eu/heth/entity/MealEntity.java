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

	/**
	 * Default const
	 */
	public MealEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
