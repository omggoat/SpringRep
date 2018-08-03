package cn.shil.control;

import cn.shil.common.AgeNotFoundException;
import cn.shil.common.DuplicateValueException;
import cn.shil.common.NameNotFoundException;
import cn.shil.entity.Student;
import cn.shil.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import cn.shil.common.CommonCodeValue;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 测试异常制定响应状态码
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAge",method = RequestMethod.GET)
    public String getAgeById(@RequestParam String id, Model model){
        if("error".equals(studentService.queryAgeById(id)))
            throw new AgeNotFoundException();
        model.addAttribute(CommonCodeValue.MODEL_ATTRIBUTE_STUDENTAGE,studentService.queryAgeById(id));
        return CommonCodeValue.RESP_RETURNCODE_SUCCESS;
    }

    /**
     * 捕捉该controller出现的AgeNotFoundException.class异常，并进行处理
     * 当既定义了@ResponseStatus又定义了@ExceptionHandler时，进@ExceptionHandler处理
     * 通常情况只定义@ResponseStatus或@ExceptionHandler
     * @return
     */
    @ExceptionHandler(AgeNotFoundException.class)
    public String handleNotFoundException(){
        return CommonCodeValue.RESP_RETURNCODE_ERROR;
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
        if("error".equals(studentService.queryNameById(id)))
              throw new NameNotFoundException();
        model.addAttribute(CommonCodeValue.MODEL_ATTRIBUTE_STUDENTNAME,studentService.queryNameById(id));
        return CommonCodeValue.RESP_RETURNCODE_HELLO;
    }

    /**
     * 处理表单参数，参数自动封装对象stu
     * 数据校验功能应用@Valid,具体校验于Student实体中配置
     * @param student
     * @param model
     * @param myphoto 上传文件时文件可能为空情况需要设置required = false属性,否则可能导致异常
     * @return
     */
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public String studentReg(
            @Valid Student student,
            Errors errors,
            Model model,
            @RequestPart(value = "myphoto",required = false) byte[] myphoto){
        if(errors.hasErrors()){
            model.addAttribute(CommonCodeValue.MODEL_ATTRIBUTE_STUDENT,student);
            return CommonCodeValue.RESP_RETURNCODE_REREG;
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

            String result = studentService.studentReg(student.getId(), student);
            if("error".equals(result))
                throw new DuplicateValueException();
            model.addAttribute(CommonCodeValue.MODEL_ATTRIBUTE_STUDENTNAME, result);
            return CommonCodeValue.RESP_RETURNCODE_SUCCESS;
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
                return CommonCodeValue.RESP_RETURNCODE_ERROR;
            } else{
                model.addAttribute(CommonCodeValue.MODEL_ATTRIBUTE_STUDENTNAME, result);
                return CommonCodeValue.RESP_RETURNCODE_SUCCESS;
            }
        }
        //可返回请求类型:redirect或者forward
//        return "redirect:/reg.jsp";
        return CommonCodeValue.RESP_RETURNCODE_ERROR;
    }

}
