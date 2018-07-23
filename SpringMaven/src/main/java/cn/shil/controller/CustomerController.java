package cn.shil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/common/custom")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET)
    public String forCustomer(){
       return "customer";
    }
}
