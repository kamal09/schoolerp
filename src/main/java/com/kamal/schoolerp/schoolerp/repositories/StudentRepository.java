package com.kamal.schoolerp.schoolerp.repositories;

import com.kamal.schoolerp.schoolerp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamal.hossain1542 on 3/7/2019.
 */
public interface  StudentRepository extends JpaRepository<Student, Integer> {
}
