package com.kamal.schoolerp.schoolerp.services.teacher;

import com.kamal.schoolerp.schoolerp.entities.Teacher;
import com.kamal.schoolerp.schoolerp.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamal.hossain1542 on 3/13/2019.
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    private void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Iterable<Teacher> listAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.delete(teacherRepository.getOne(id));
    }
}
