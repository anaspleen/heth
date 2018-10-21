/**
 * 
 */

package eu.heth.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * Class to manage messages of errors
 * 
 * @author tcaiati
 *
 */
public class MessageBean implements Serializable {
	// -------------------------------------------------------- Static variables

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------ Instance variables

	/**
	 * Key / ID
	 */
	private final String m_Id;

	/**
	 * Bundle
	 */
	private final String m_Bundle;

	/**
	 * Type of message
	 */
	private final String m_KindOfMessage;

	/**
	 * Parameters
	 */
	private final List m_Parameters = new ArrayList();

	/**
	 * Const with ID
	 * 
	 * @param p_Id
	 *            ID
	 * @param p_KindOfMessage
	 *            type
	 * @param p_Bundle
	 *            bundle
	 */
	protected MessageBean(String p_Id, String p_KindOfMessage, String p_Bundle) {
		m_Id = p_Id;
		m_KindOfMessage = p_KindOfMessage;
		m_Bundle = p_Bundle;
	}

	/**
	 * Const with ID
	 * 
	 * @param p_Id
	 *            ID
	 */
	public MessageBean(String p_Id) {
		this(p_Id, (String) null);
	}

	/**
	 * Const with ID
	 * 
	 * @param p_Id
	 *            ID
	 * @param p_Bundle
	 *            bundle
	 */
	public MessageBean(String p_Id, String p_Bundle) {
		this(p_Id, "MessageBean", p_Bundle);
	}

	/**
	 * Const with ID
	 * 
	 * @param p_Id
	 *            ID
	 * @param p_Param
	 *            parameter
	 */
	public MessageBean(String p_Id, Object p_Param) {
		this(p_Id, p_Param, null);
	}

	/**
	 * Const with ID
	 * 
	 * @param p_Id
	 *            ID
	 * @param p_Param
	 *            parameter
	 * @param p_Bundle
	 *            bundle
	 */
	public MessageBean(String p_Id, Object p_Param, String p_Bundle) {
		this(p_Id, p_Bundle);
		addParameter(p_Param);
	}

	/**
	 * Const with ID
	 * 
	 * @param p_Id
	 *            ID
	 * @param p_ListeParam
	 *            parameters
	 */
	public MessageBean(String p_Id, Object[] p_ListeParam) {
		this(p_Id, p_ListeParam, null);
	}

	/**
	 * Const with ID
	 * 
	 * @param p_Id
	 *            ID
	 * @param p_ListeParam
	 *            parameters
	 * @param p_Bundle
	 *            bundle
	 */
	public MessageBean(String p_Id, Object[] p_ListeParam, String p_Bundle) {
		this(p_Id, p_Bundle);
		for (int i = 0; i < p_ListeParam.length; i++) {
			addParameter(p_ListeParam[i]);
		}
	}

	// ---------------------------------------------------------- Public methods

	public String getId() {
		return m_Id;
	}

	public String getBundle() {
		return m_Bundle;
	}

	/**
	 * Add parameter
	 * 
	 * @param p_Param
	 *            parameter to add
	 */
	public void addParameter(Object p_Param) {
		m_Parameters.add(convert(p_Param));
	}

	public String[] getParameters() {
		return (String[]) m_Parameters.toArray(new String[m_Parameters.size()]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = m_KindOfMessage + ": " + m_Id;
		if (m_Parameters.size() > 0) {
			result += " (" + m_Parameters.toString() + ")";
		}
		return result;
	}

	/**
	 * To convert object to string.
	 * 
	 * @param p_Source
	 *            object source
	 * @return the string
	 */
	private String convert(Object p_Source) {
		String converted = null;
		converted = ConvertUtils.convert(p_Source);
		return converted;
	}
}
