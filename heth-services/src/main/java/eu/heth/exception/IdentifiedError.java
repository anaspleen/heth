/**
 * 
 */

package eu.heth.exception;

import java.io.Serializable;

/**
 * Class to represent an error.
 */
public class IdentifiedError extends MessageBean implements Serializable {
	// -------------------------------------------------------- Static variables

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------ Instance variables

	/**
	 * Cause of error
	 */
	private final transient Throwable m_Cause;

	// -------------------------------------------------------------
	// Constructors

	/**
	 * Const with ID
	 * 
	 * @param cause
	 *            Cause
	 * @param id
	 *            ID
	 */
	public IdentifiedError(Throwable cause, String id) {
		super(id, "IdentifiedError", null);
		m_Cause = cause;
	}

	/**
	 * Const with ID
	 * 
	 * @param id
	 *            ID
	 */
	public IdentifiedError(String id) {
		this((Throwable) null, id);
	}

	/**
	 * Const with ID
	 * 
	 * @param id
	 *            ID
	 * @param param
	 *            parameter
	 */
	public IdentifiedError(String id, Object param) {
		this((Throwable) null, id);
		addParameter(param);
	}

	/**
	 * Const with ID
	 * 
	 * @param id
	 *            ID
	 * @param param0
	 *            parameter
	 * @param param1
	 *            parameter
	 */
	public IdentifiedError(String id, Object param0, Object param1) {
		this((Throwable) null, id);
		addParameter(param0);
		addParameter(param1);
	}

	/**
	 * Const with ID
	 * 
	 * @param id
	 *            ID
	 * @param listeParam
	 *            parameters
	 */
	public IdentifiedError(String id, Object[] listeParam) {
		this((Throwable) null, id);
		for (int i = 0; i < listeParam.length; i++) {
			addParameter(listeParam[i]);
		}
	}

	/**
	 * Const with ID
	 * 
	 * @param cause
	 *            cause
	 * @param id
	 *            ID
	 * @param param
	 *            parameter
	 */
	public IdentifiedError(Throwable cause, String id, Object param) {
		this(cause, id);
		addParameter(param);
	}

	// ---------------------------------------------------------- Public methods

	/**
	 * Get cause.
	 * 
	 * @return Cause or null if not exists
	 */
	public Throwable getCause() {
		return m_Cause;
	}
}
