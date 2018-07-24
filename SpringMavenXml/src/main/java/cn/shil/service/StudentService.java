package cn.shil.service;

import cn.shil.dao.IStudentDao;
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
}
