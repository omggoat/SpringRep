package cn.shil.utils;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyFilterInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("myfilter",MyFilter.class);
        dynamic.addMappingForUrlPatterns(null,false,"/custom");
    }
}
