package cn.shil.dao;

import org.springframework.stereotype.Repository;

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
}
