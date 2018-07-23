package cn.shil.utils;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyServletInitializer implements WebApplicationInitializer
{
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("myservlet",MyServlet.class);
        dynamic.addMapping("/custom");
    }
}
