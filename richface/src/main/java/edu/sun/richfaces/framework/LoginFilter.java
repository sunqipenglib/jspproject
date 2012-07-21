package edu.sun.richfaces.framework;

import edu.sun.richfaces.manage.LoginBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //filterChain.doFilter(servletRequest, servletResponse);
        //HttpSession session = servletRequest.getSession();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getSession().getAttribute(Contant.USER_INFORMATION_IN_SESSION) == null) {
            redirectToLogin(response, request);
        }

        Object user = request.getSession().getAttribute(Contant.USER_INFORMATION_IN_SESSION);
        if (user
                instanceof LoginBean) {
            LoginBean lb = (LoginBean) user;
            if (!lb.isLogin())
                redirectToLogin(response, request);
        } else {
            redirectToLogin(response, request);
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    private void redirectToLogin(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendRedirect(request.getContextPath() + "/login.jsf");
    }

    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
