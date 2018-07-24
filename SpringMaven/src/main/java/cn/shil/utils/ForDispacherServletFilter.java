package cn.shil.utils;

import javax.servlet.*;
import java.io.IOException;

public class ForDispacherServletFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ForDispacherServletFilter init Method...");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ForDispacherServletFilter doFilter Method before(begin to DispacherServlet)...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("ForDispacherServletFilter doFilter Method after(return from DispacherServlet)...");
    }

    public void destroy() {
        System.out.println("ForDispacherServletFilter destroy Method...");
    }
}
