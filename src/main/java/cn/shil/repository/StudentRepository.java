package cn.shil.repository;

import cn.shil.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentRepository implements IStudentRepository{
    public List<Student> findAllStudents() {
        Student stu1 = new Student(10,"zhangsan","nv","20");
        Student stu2 = new Student(11,"lisi","nv","22");
        return Arrays.asList(stu1,stu2);
    }
}
