package cn.shil.control;

import cn.shil.entity.Student;
import cn.shil.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 处理路径参数请求输入@PathVariable("id")
     * 请求类似/login/12345
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryNameById/{id}",method = RequestMethod.GET)
    public String getStudentNameByID(Model model, @PathVariable("id") String id){
        model.addAttribute("stuname",studentService.queryNameById(id));
        return "hello";
    }

    /**
     * 处理表单参数，参数自动封装对象stu
     * 数据校验功能应用@Validated,具体校验于Student实体中配置
     * @param stu
     * @param model
     * @return
     */
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public String studentReg(
            @Valid Student stu,
            @RequestPart(value = "myphoto") byte[] myphoto,
            Errors errors,
            Model model){
        if(errors.hasErrors()){
            model.addAttribute("student",stu);
            return "regnew";
        }else {/*
            File file = new File("F:/myphone.jpeg");
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(myphoto);
                outputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }*/
            String result = studentService.studentReg(stu.getId(), stu);
            model.addAttribute("name", result);
            return "success";
        }
    }

    /**
     * 处理查询参数@RequestParam("id")
     * 请求类似/login?id=12345&name=zhangsan
     * @param id
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String studentLogin(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            Model model
    ){
        String result = studentService.studentLogin(id,name);
        return getModelAndView(model, result);
    }

    public String getModelAndView(Model model, String result) {
        if(null!=result&&!"".equals(result)){
            if("error".equals(result)) {
                return "error";
            } else{
                model.addAttribute("name", result);
                return "success";
            }
        }
        //可返回请求类型:redirect或者forward
//        return "redirect:/reg.jsp";
        return "error";
    }
}
