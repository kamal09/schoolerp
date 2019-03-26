package com.kamal.schoolerp.schoolerp.repositories;

import com.kamal.schoolerp.schoolerp.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamal.hossain1542 on 3/13/2019.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
