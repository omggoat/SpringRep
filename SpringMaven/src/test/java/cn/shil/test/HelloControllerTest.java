package cn.shil.test;

import cn.shil.controller.HelloController;
import cn.shil.repository.IStudentRepository;
import cn.shil.repository.StudentRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HelloControllerTest {

    @Test
    public void testController() throws Exception{
        HelloController controller = new HelloController();
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
            mvc.perform(get("/hello")).andExpect(view().name("success"));
    }

    @Test
    public void testController2() throws Exception{

        HelloController controller = new HelloController();
        controller.setIsp(new StudentRepository());
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
        mvc.perform(get("/hello/query")).andExpect(view().name("querylist"));
    }
}
