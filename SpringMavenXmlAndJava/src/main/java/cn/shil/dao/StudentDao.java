package cn.shil.dao;

import cn.shil.entity.Student;
import cn.shil.util.FileDB;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class StudentDao implements IStudentDao{

    private Map<String,Object> map =  FileDB.getFiledb();

    @Override
    public String queryNameById(String id) {
        if (id != null && !id.isEmpty() && id.trim().length() != 0) {
            if (map.keySet().contains(id)) {
                Student stu = (Student) map.get(id);
                return stu.getName();
            }else {
                return "error";
            }
        } else {
            return "error";
        }
    }

    @Override
    public String queryAgeById(String id) {
        if (id != null && !id.isEmpty() && id.trim().length() != 0) {
            if (map.keySet().contains(id)) {
                Student stu = (Student) map.get(id);
                return Integer.toString(stu.getAge());
            }else {
                return "error";
            }
        } else {
            return "error";
        }
    }

    @Override
    public String studentReg(String id,Student o) {
        if(map.keySet().contains(id)){
            return "duplicate name";
        }else{
            map.put(id,o);
            return o.getName();
        }
    }

    @Override
    public String studentLogin(String id, String name) {
        Student stu = (Student)map.get(id);
        if(null==stu){
            return "error";
        }else{
            if(name.equals(stu.getName())){
                return name;
            }else{
                return "error";
            }
        }
    }
}
