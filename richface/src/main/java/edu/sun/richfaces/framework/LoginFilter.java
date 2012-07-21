package edu.sun.richfaces.framework;

import javax.servlet.*;
import java.io.IOException;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
