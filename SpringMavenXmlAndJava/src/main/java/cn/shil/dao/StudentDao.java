package cn.shil.dao;

import cn.shil.entity.Student;
import cn.shil.util.FileDB;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class StudentDao implements IStudentDao{


    @Override
    public String queryNameById(String id) {
        if (id!=null&&!id.isEmpty()&&id.trim().length()!=0){
            if(id=="1"){
                return "zhang san feng";
            }else if(id=="2"){
                return "zhang wu ji";
            }else{
                return "no name hero";
            }
        }else{
            return "id is null";
        }
    }

    @Override
    public String studentReg(String id,Student o) {
        Map<String,Object> map =  FileDB.getFiledb();
        if(map.keySet().contains(id)){
            return "error";
        }else{
            map.put(id,o);
            return o.getName();
        }
    }

    @Override
    public String studentLogin(String id, String name) {
        Map<String,Object> map =  FileDB.getFiledb();
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
