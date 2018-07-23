package cn.shil.repository;

import cn.shil.entity.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAllStudents();
}
