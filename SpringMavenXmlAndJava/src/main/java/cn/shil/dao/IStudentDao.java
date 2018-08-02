package cn.shil.dao;

import cn.shil.entity.Student;

public interface IStudentDao {
    String queryNameById(String id);
    String queryAgeById(String id);
    String studentReg(String id,Student o);
    String studentLogin(String id, String name);
}
