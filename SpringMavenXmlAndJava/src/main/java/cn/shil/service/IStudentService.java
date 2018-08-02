package cn.shil.service;

import cn.shil.entity.Student;

public interface IStudentService {
    String queryNameById(String id);
    String queryAgeById(String id);
    String studentReg(String id,Student o);
    String studentLogin(String id, String name);
}
