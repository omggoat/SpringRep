package cn.shil.service;

import cn.shil.dao.IStudentDao;
import cn.shil.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{

    private IStudentDao studentDao;

    @Autowired
    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public String queryNameById(String id) {
        return studentDao.queryNameById(id);
    }

    @Override
    public String queryAgeById(String id) {
        return studentDao.queryAgeById(id);
    }

    @Override
    public String studentReg(String id, Student o) {
        return studentDao.studentReg(id,o);
    }

    @Override
    public String studentLogin(String id, String name) {
        return studentDao.studentLogin(id,name);
    }
}
