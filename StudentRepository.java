package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Student entity.
 * This interface handles all the database operations (CRUD) for the Student entity.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // JpaRepository provides methods like findAll(), findById(), save(), deleteById() etc.
    // No need to write any implementation code.
}

