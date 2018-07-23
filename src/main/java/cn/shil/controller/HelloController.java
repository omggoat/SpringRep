package cn.shil.controller;

import cn.shil.entity.Student;
import cn.shil.repository.IStudentRepository;
import cn.shil.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 当控制器在类级别上添加@RequestMapping注解时，这个注解会应用到
 * 控制器的所有处理器方法上。处理器方法上的@RequestMapping注
 * 解会对类级别上的@RequestMapping的声明进行补充
 */
@Controller
@RequestMapping("/common")
public class HelloController {

    private IStudentRepository isp;


    @Autowired
    public void setIsp(IStudentRepository isp) {
        this.isp = isp;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloMvc(){
        return "success";
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String findAllStudents(Model model){
        model.addAttribute("stu",isp.findAllStudents());
        return "querylist";
    }
}
