package com.Project.SpringAngular.StudentRepo;


import com.Project.SpringAngular.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo  extends JpaRepository<Student, Integer> {

}
