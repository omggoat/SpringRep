package cn.shil.control;

import cn.shil.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/queryNameById",method = RequestMethod.GET)
    public String getStudentNameByID(Model model){
        model.addAttribute("stuname",studentService.queryNameById("1"));
        return "hello";
    }
}
