/**
 * 
 */
package eu.heth.exception;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Common filter
 * 
 * @author thomas
 */
public class SetCharacterEncodingFilter implements Filter {

	/** encoding */
	private String encoding;

	/** to desactivate filter */
	private boolean ignore;

	/** Const */
	public SetCharacterEncodingFilter() {
		encoding = null;
		ignore = true;
	}

	/**
	 * It's the end !
	 *
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		encoding = null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, * javax.servlet .FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (ignore || request.getCharacterEncoding() == null) {
			String encoding = selectEncoding(request);
			if (encoding != null) {
				request.setCharacterEncoding(encoding);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if (value == null) {
			ignore = true;
		} else if (value.equalsIgnoreCase("true")) {
			ignore = true;
		} else if (value.equalsIgnoreCase("yes")) {
			ignore = true;
		} else {
			ignore = false;
		}
	}

	/**
	 * Util ?
	 *
	 * @param request
	 *            the request
	 *
	 * @return encoding.
	 */
	protected String selectEncoding(ServletRequest request) {
		return encoding;
	}
}
