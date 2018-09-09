/*
 * 
 */
package eu.heth.exception;

/**
 * Tecnical exception
 * 
 * @author tomey
 *
 */
public class SystemException extends Exception {
	/** Serial UID. */
	private static final long serialVersionUID = -4479897795523769658L;

	/**
	 * const.
	 *
	 * @param message
	 *            message of exception
	 * @param cause
	 *            of exception
	 */
	public SystemException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * const.
	 *
	 * @param message
	 *            message of exception
	 */
	public SystemException(final String message) {
		super(message);
	}
}
