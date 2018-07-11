package cn.shil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 当控制器在类级别上添加@RequestMapping注解时，这个注解会应用到
 * 控制器的所有处理器方法上。处理器方法上的@RequestMapping注
 * 解会对类级别上的@RequestMapping的声明进行补充
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloMvc(){
        return "success";
    }
}
