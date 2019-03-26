package com.kamal.schoolerp.schoolerp.services.teacher;

import com.kamal.schoolerp.schoolerp.entities.Teacher;

/**
 * Created by kamal.hossain1542 on 3/13/2019.
 */

public interface TeacherService {

    Iterable<Teacher> listAllTeachers();

    Teacher getTeacherById(Integer id);

    Teacher saveTeacher(Teacher teacher);

    void deleteTeacher(Integer id);

}
