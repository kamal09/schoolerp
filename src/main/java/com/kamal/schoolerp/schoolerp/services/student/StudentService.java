package com.kamal.schoolerp.schoolerp.services.student;

import com.kamal.schoolerp.schoolerp.entities.Student;

/**
 * Created by kamal.hossain1542 on 3/7/2019.
 */
public interface StudentService {

    Iterable<Student> listAllStudents();

    Student getStudentById(Integer id);

    Student saveStudent(Student student);

    void deleteStudent(Integer id);
}
