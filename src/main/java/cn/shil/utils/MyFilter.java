package cn.shil.utils;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Init...");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter doFilter Method Before...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter doFilter Method After...");
    }

    public void destroy() {
        System.out.println("Filter Destory...");
    }
}
