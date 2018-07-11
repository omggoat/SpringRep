package cn.shil.utils;

import cn.shil.config.RootConfig;
import cn.shil.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 方法返回的带有@Configuration注解的类(RootConfig.class)将会用来配置ContextLoaderListener创建的应用上下文中的bean
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 方法返回的带有@Configuration注解的类(WebConfig.class)将会用来定义DispatcherServlet创建的应用上下文中的bean
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 配置将所有的url请求映射到DispacherServlet中，dispacherServlet作为请求的默认servlet
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
