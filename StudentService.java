package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer that contains the business logic for student management.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Retrieves all students from the database.
     * @return A list of all students.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Retrieves a student by their ID.
     * @param id The ID of the student to retrieve.
     * @return An Optional containing the student if found, otherwise empty.
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Creates and saves a new student.
     * @param student The student object to be created.
     * @return The saved student object.
     */
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Updates an existing student's information.
     * @param id The ID of the student to update.
     * @param studentDetails The new details for the student.
     * @return The updated student object, or null if the student was not found.
     */
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setFirstName(studentDetails.getFirstName());
            existingStudent.setLastName(studentDetails.getLastName());
            existingStudent.setEmail(studentDetails.getEmail());
            return studentRepository.save(existingStudent);
        }
        return null; // Or throw an exception
    }

    /**
     * Deletes a student by their ID.
     * @param id The ID of the student to delete.
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
