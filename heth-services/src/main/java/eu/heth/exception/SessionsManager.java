/**
 * 
 */
package eu.heth.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To manage Sessions Cap
 * 
 * @author tcaiati
 */
public class SessionsManager implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * log
	 */
	private static final Logger LOG = LoggerFactory.getLogger(SessionsManager.class);

	/** Table thread / session */
	private static Map<Long, Session> sessions = new HashMap<Long, Session>();

	/**
	 * Table thread / number
	 */
	private static Map<Long, Integer> references = new HashMap<Long, Integer>();

	/**
	 * To synchronize sessions and references
	 */
	private static Object s_Lock = new Object();

	/**
	 * Default const.
	 */
	protected SessionsManager() {
		// NTD
	}

	/**
	 * 
	 * @return Number sessions treated.
	 */
	public static int getNumberSessionsInProgress() {
		return sessions.size();
	}

	/**
	 * Get the current session to the current thread
	 * 
	 * @param returnDefaultIfNull
	 *            return default session if no found
	 * @return Session or null
	 */
	public static Session getSession(boolean returnDefaultIfNull) {
		Session session = null;
		try {
			// To synchronize sessions and references
			synchronized (s_Lock) {
				session = sessions.get(Thread.currentThread().getId());
			}
			if ((session == null) && (returnDefaultIfNull == true)) {
				session = Session.SESSION_DEFAULT;
			}
		} catch (Throwable t) {
			session = null;
		}
		return session;
	}

	/**
	 * Get the current session linked to id.
	 * 
	 * @param returnDefaultIfNull
	 *            return default session if no found
	 * @param id
	 *            id session
	 * @return Session or null
	 */
	public static Session getSession(final boolean returnDefaultIfNull, final Long id) {
		Session session = null;
		try {
			// To synchronize sessions and references
			synchronized (s_Lock) {
				session = sessions.get(id);
				LOG.debug("Session a renvoyer " + session.getIdSession() + " " + session.getIdRequest());
			}
			if ((session == null) && (returnDefaultIfNull == true)) {
				session = Session.SESSION_DEFAULT;
				LOG.debug("Session to get : DEFAULT");
			}
		} catch (Throwable t) {
			session = null;
		}
		return session;
	}

	/**
	 * This method must be called in start of request to link session with current
	 * thread
	 * 
	 * @param session
	 *            session
	 * @throws Exception
	 *             error
	 */
	public static void referenceSession(Session session) throws Exception {
		referenceSession(session, session.getIdRequest() + 1);
	}

	/**
	 * This method must be called in start of request to link session with current
	 * thread
	 * 
	 * @param session
	 *            session
	 * @param p_NewRequest
	 *            true if current request is new
	 * @throws Exception
	 *             error
	 */
	public static void referenceSession(final Session session, final boolean p_NewRequest) throws Exception {
		if (true == p_NewRequest) {
			referenceSession(session, session.getIdRequest() + 1);
		} else {
			referenceSession(session, session.getIdRequest());
		}

	}

	/**
	 * This method must be called in start of request to link session with current
	 * thread and set id request
	 * 
	 * @param pSession
	 *            session
	 * @param pIdRequest
	 *            id request
	 * @throws Exception
	 *             error
	 */
	public static void referenceSession(Session pSession, Integer pIdRequest) throws Exception {
		Long id = null;
		Session session = null;
		boolean newSession = false;
		try {
			if (pSession != null) {
				id = Thread.currentThread().getId();

				// To synchronize sessions and references
				synchronized (s_Lock) {
					session = sessions.get(id);
					newSession = (session == null) || (session != pSession);
					if (false == newSession) {
						references.put(id, new Integer(references.get(id).intValue() + 1));
					} else {
						sessions.put(id, pSession);
						references.put(id, new Integer(1));
					}
				}
				pSession.setIdRequest(pIdRequest);
			} else {
				throw new Exception("Session to reference is null");
			}
		} catch (Exception e) {
			throw e;
		} catch (Throwable t) {
			throw new Exception("Error on referencing session : " + t.toString(), t);
		}
	}

	/**
	 * Method must be called at the end of request to unlink current session to
	 * current thread and delete id request
	 * 
	 * @throws Exception
	 *             error
	 */
	public static void unreferenceSession() throws Exception {
		Long id = null;
		Session session = null;
		boolean aTraiter = false;
		int nbSessions = -1;
		try {
			id = Thread.currentThread().getId();

			// To synchronize sessions and references
			synchronized (s_Lock) {
				session = sessions.get(id);
				nbSessions = references.get(id).intValue();
				aTraiter = (null != session) && (1 >= nbSessions);
				if (true == aTraiter) {
					sessions.remove(id);
					references.remove(id);
				} else if (1 < nbSessions) {
					nbSessions--;
					references.put(id, new Integer(nbSessions));
				}
			}
		} catch (Throwable t) {
			throw new Exception("Error on unreferencing session : " + t.toString(), t);
		}
	}

	/**
	 * Save session
	 */
	public static void saveSessionBatch() {
		Session session = new Session("BATCH");
		try {
			SessionsManager.referenceSession(session);
		} catch (Exception e) {
			if (true == LOG.isErrorEnabled()) {
				LOG.error("Error on saving session : ", e);
			}
		}
	}

	/**
	 * Unsave session
	 */
	public static void unsaveSessionBatch() {
		try {
			SessionsManager.unreferenceSession();
		} catch (Exception e) {
			if (true == LOG.isErrorEnabled()) {
				LOG.error("Error on unsaving session : ", e);
			}
		}
	}
}
