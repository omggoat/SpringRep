package cn.shil.utils;

import cn.shil.config.RootConfig;
import cn.shil.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

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
     * 方法返回的带有@Configuration注解的类(WebConfig.class)将会用来定义DispatcherServlet创建的Spring应用上下文中的bean
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
        return new String[]{"/common","/common/query","/common/custom"};
    }


    /**
     *  此处的registration相当于注册DispacherServlet后返回的该对象信息，所以调用registration相应方法
     *  就相当于改变DispacherServlet对象的行为
     *
     *  限制文件的大小不超过2MB，整个请求不超过
     * 4MB，而且所有的文件都要写到磁盘中（对应参数0，在上传的过程中，如果文件大小达到了一个指定最大容量（以字
     * 节为单位），将会写入到临时文件路径中。默认值为0，也就是
     * 所有上传的文件都会写入到磁盘上）
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(
                "D:/uploaddir",
                2097152,
                4194304,
                0));
    }

    /**
     * getServletFilters()方法返回的所有Filter都会映射到DispatcherServlet上
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new ForDispacherServletFilter()};
    }
}
