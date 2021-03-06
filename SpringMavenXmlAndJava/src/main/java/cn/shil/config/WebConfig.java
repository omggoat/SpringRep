package cn.shil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * ComponentScan 扫描@Conmponent或者@Controller注解的组件
 */
@ComponentScan("cn.shil.control")
@Configuration
//启用Spring MVC,基于JavaConfig配置通过@EnableWebMvc注解实现，基于Xml配置通过<mvc:annotation-driven>启用注解驱动的Spring MVC
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置视图解析器
     * @return
     */
    @Bean
    public ViewResolver getViewResolver(){

        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setSuffix(".jsp");
        vr.setPrefix("/WEB-INF/jsp/");
        vr.setExposeContextBeansAsAttributes(true);
        return vr;
    }

    /**
     * 对静态资源的请求转发到Servlet容器中默认的Servlet上，而不是使用DispatcherServlet本身来处理此类请求
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * DispatcherServlet初始化策略时从Spirng上下文中获取bean策略
     * 源码：initMultipartResolver(ApplicationContext context){context.getBean("multipartResolver", MultipartResolver.class)}
     * 具体策略算法在bean对应类的具体实现中
     * @return
     */
    @Bean
    public MultipartResolver getMultipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
