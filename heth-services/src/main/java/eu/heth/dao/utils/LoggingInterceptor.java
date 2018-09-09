/**
 * 
 */
package eu.heth.dao.utils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

/**
 * 
 * It's a "advice" Spring to log in / ou Spring methods. It's used with AOP
 * 
 * @author tomey
 */
public class LoggingInterceptor implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method,
	 *      java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void before(Method p_Method, Object[] p_Args, Object p_Target) {
		String message = null;
		String messagearguments = null;
		Logger logger = LoggerFactory.getLogger(getTargetObject(p_Target).getClass());
		if (true == logger.isDebugEnabled()) {
			message = ">>>>> " + p_Method.getName();
			if (null != p_Args && p_Args.length > 0) {
				try {
					messagearguments = "(";
					for (int i = 0; i < p_Args.length; i++) {
						if (null == p_Args[i]) {
							messagearguments += p_Args[i];
						} else {
							messagearguments += p_Args[i].toString();
						}
						if (i == p_Args.length - 1) {
							messagearguments += ")";
						} else {
							messagearguments += ",";
						}
					}
				} catch (Exception ze) {
					// NTD
				}
				if (messagearguments.indexOf("password") == -1) {
					message += messagearguments;
				}
			}
			logger.debug(message);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object,
	 *      java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void afterReturning(Object p_ReturnValue, Method p_Method, Object[] p_Args, Object p_Target) {
		Logger logger = LoggerFactory.getLogger(getTargetObject(p_Target).getClass());

		if (true == logger.isDebugEnabled()) {
			String message = "<<<<< " + p_Method.getName() + ":";
			if (null != p_ReturnValue) {
				try {
					if (true == p_ReturnValue.getClass().isArray()) {
						int taille = Array.getLength(p_ReturnValue);
						message += "[";
						for (int i = 0; i < taille - 1; i++) {
							message += Array.get(p_ReturnValue, i);
							message += ",";
						}
						if (taille > 0) {
							message += Array.get(p_ReturnValue, taille - 1);
						}
						message += "]";
					} else {
						message += p_ReturnValue;
					}
				} catch (Exception ze) {
					ze.printStackTrace();
					// on ne fait rien
				}
			}
			logger.debug(message);
		}
	}

	/**
	 * After throwing.
	 *
	 * @param p_Method            the logged method
	 * @param p_Args            the method's arguments
	 * @param p_Target            the target object
	 * @param p_Ex            the thrown exception
	 */
	public void afterThrowing(Method p_Method, Object[] p_Args, Object p_Target, Exception p_Ex) {
		Logger logger = LoggerFactory.getLogger(getTargetObject(p_Target).getClass());

		if (true == logger.isErrorEnabled()) {
			logger.error("EXCEPTION (" + p_Ex.getClass().getName() + ") IN METHOD : " + p_Method.getName()
					+ " - Exception is " + p_Ex.getMessage());
		}
		if (true == logger.isDebugEnabled()) {
			logger.debug("TRACE de l'exception (" + p_Ex.getClass().getName() + ") IN METHOD : " + p_Method.getName()
					+ " - Exception is " + p_Ex.getMessage(), p_Ex);
		}
	}

	/**
	 * If p_Object is a proxy, return proxy target else the object. To logs
	 * classe name (and no proxy name)
	 *
	 * @param p_Object            object
	 * @return the target object
	 * @returnIf p_Object is a proxy, return proxy target else the object
	 */
	private Object getTargetObject(final Object p_Object) {
		try {
			if (AopUtils.isJdkDynamicProxy(p_Object)) {
				return ((Advised) p_Object).getTargetSource().getTarget();
			}
		} catch (Exception e) {
			// NTD
		}
		return p_Object;
	}
}
