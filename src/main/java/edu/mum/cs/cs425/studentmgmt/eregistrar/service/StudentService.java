package edu.mum.cs.cs425.studentmgmt.eregistrar.service;

import edu.mum.cs.cs425.studentmgmt.eregistrar.model.Student;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    void addStudent(@ModelAttribute("student") Student student);

    void deleteStudent(String studentNumber);

    Student getStudentByStudentNumber(String studentNumber);

    void editStudent(Student student);
}
