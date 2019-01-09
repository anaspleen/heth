/**
 * 
 */
package eu.heth.utils;

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
	public void before(Method method, Object[] args, Object target) {
		String message = null;
		String messagearguments = null;
		Logger logger = LoggerFactory.getLogger(getTargetObject(target).getClass());
		if (logger.isDebugEnabled()) {
			message = ">>>>> " + method.getName();
			if (null != args && args.length > 0) {
				try {
					messagearguments = "(";
					for (int i = 0; i < args.length; i++) {
						if (null == args[i]) {
							messagearguments += args[i];
						} else {
							messagearguments += args[i].toString();
						}
						if (i == args.length - 1) {
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
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) {
		Logger logger = LoggerFactory.getLogger(getTargetObject(target).getClass());

		if (logger.isDebugEnabled()) {
			String message = "<<<<< " + method.getName() + ":";
			if (null != returnValue) {
				try {
					if (returnValue.getClass().isArray()) {
						int taille = Array.getLength(returnValue);
						message += "[";
						for (int i = 0; i < taille - 1; i++) {
							message += Array.get(returnValue, i);
							message += ",";
						}
						if (taille > 0) {
							message += Array.get(returnValue, taille - 1);
						}
						message += "]";
					} else {
						message += returnValue;
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
	 * @param method
	 *            the logged method
	 * @param args
	 *            the method's arguments
	 * @param target
	 *            the target object
	 * @param ex
	 *            the thrown exception
	 */
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		Logger logger = LoggerFactory.getLogger(getTargetObject(target).getClass());

		if (logger.isErrorEnabled()) {
			logger.error("EXCEPTION (" + ex.getClass().getName() + ") IN METHOD : " + method.getName()
					+ " - Exception is " + ex.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("TRACE de l'exception (" + ex.getClass().getName() + ") IN METHOD : " + method.getName()
					+ " - Exception is " + ex.getMessage(), ex);
		}
	}

	/**
	 * If p_Object is a proxy, return proxy target else the object. To logs
	 * classe name (and no proxy name)
	 *
	 * @param object
	 *            object
	 * @return the target object
	 * @returnIf p_Object is a proxy, return proxy target else the object
	 */
	private Object getTargetObject(final Object object) {
		try {
			if (AopUtils.isJdkDynamicProxy(object)) {
				return ((Advised) object).getTargetSource().getTarget();
			}
		} catch (Exception e) {
			// NTD
		}
		return object;
	}
}
