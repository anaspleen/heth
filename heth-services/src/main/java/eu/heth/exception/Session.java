/**
 * 
 */
package eu.heth.exception;

import java.io.Serializable;

/**
 * Session for logs
 * 
 * @author tcaiati
 */
public class Session implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = 5663711766496307158L;

	/**
	 * Number sessions created
	 */
	private static Long numberSessionsCreated = new Long(0);

	/**
	 * Number sessions in progress
	 */
	private static int numberSessionsInProgress;

	/**
	 * counter
	 */
	private static int counter = 0;

	/**
	 * id session
	 */
	private String idSession;

	/**
	 * id request
	 */
	private Integer idRequest = 0;

	/**
	 * id appelant
	 */
	private String appelant = null;

	/**
	 * Boolean to get if request had a session cookie ans session is out => time out
	 */
	private boolean renewAfterTimeout = false;

	/**
	 * synchro
	 */
	private static Object synchro = new Object();

	/**
	 * Default session
	 */
	public static final Session SESSION_DEFAULT = new Session("DEFAULT");

	/**
	 * @return the idSession
	 */
	public String getIdSession() {
		return idSession;
	}

	/**
	 * @param idSession
	 *            the idSession to set
	 */
	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	/**
	 * @return the idRequest
	 */
	public Integer getIdRequest() {
		return idRequest;
	}

	/**
	 * @param idRequest
	 *            the idRequest to set
	 */
	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	/**
	 * @return the appelant
	 */
	public String getAppelant() {
		return appelant;
	}

	/**
	 * @param appelant
	 *            the appelant to set
	 */
	public void setAppelant(String appelant) {
		this.appelant = appelant;
	}

	/**
	 * @return true si la session a été crée après un timeout
	 */
	public boolean isRenewAfterTimeout() {
		return renewAfterTimeout;
	}

	/**
	 * @param p_RenewAfterTimeout
	 *            pour indiquer si la session a été crée après un timeout. (par
	 *            défaut à false, donc...)
	 */
	public void setRenewAfterTimeout(boolean p_RenewAfterTimeout) {
		renewAfterTimeout = p_RenewAfterTimeout;
	}

	/**
	 * Const to logs.
	 * 
	 * @param p_Appelant
	 *            L'appelant
	 */
	public Session(String p_Appelant) {

		// increment counter to count number objets sessions created
		this.appelant = p_Appelant;
		numberSessionsCreated = (numberSessionsCreated + 1) % Long.MAX_VALUE;
		synchronized (synchro) {
			counter = (counter + 1) % Integer.MAX_VALUE;
			idSession = Long.toString(counter);
		}
		numberSessionsInProgress++;
	}

	/**
	 * Default constt.
	 */
	public Session() {

		// increment counter to count number objets sessions created
		this.appelant = "DEFAULT";
		numberSessionsCreated = (numberSessionsCreated + 1) % Long.MAX_VALUE;
		synchronized (synchro) {
			counter = (counter + 1) % Integer.MAX_VALUE;
			idSession = Long.toString(counter);
		}
		numberSessionsInProgress++;
	}
}
