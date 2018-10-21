/**
 * 
 */

package eu.heth.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent applicatives exceptions (field empty ...)
 * 
 * @author tcaiati
 *
 */
public class ApplicationException extends Exception {
	// --------------------------------------------------------------- Constants

	// -------------------------------------------------------- Static variables

	/**
	 * serialID
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------ Instance variables

	/**
	 * List of errors
	 */
	private final List errors = new ArrayList();

	// -------------------------------------------------------------
	// Constructors

	/**
	 * Const with ID
	 * 
	 * @param id
	 *            ID of error
	 */
	public ApplicationException(String id) {
		errors.add(new IdentifiedError(id));
	}

	/**
	 * Const with error
	 * 
	 * @param error
	 *            error
	 */
	public ApplicationException(IdentifiedError error) {
		errors.add(error);
	}

	/**
	 * Const with errors
	 * 
	 * @param p_ListError
	 *            errors
	 */
	public ApplicationException(IdentifiedError[] p_ListError) {
		for (int i = 0; i < p_ListError.length; i++) {
			errors.add(p_ListError[i]);
		}
	}

	/**
	 * Const with errors
	 * 
	 * @param p_ListError
	 *            errors
	 */
	public ApplicationException(List p_ListError) {
		errors.addAll(p_ListError);
	}

	// ---------------------------------------------------------- Public methods

	/**
	 * Get all errors
	 * 
	 * @return errors
	 */
	public IdentifiedError[] getErrors() {
		return (IdentifiedError[]) errors.toArray(new IdentifiedError[errors.size()]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ApplicationException : " + errors.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getCause()
	 */
	public Throwable getCause() {
		Throwable result = null;
		IdentifiedError error = (IdentifiedError) errors.get(0);
		if (null != error) {
			result = error.getCause();
		}
		return result;
	}
}
