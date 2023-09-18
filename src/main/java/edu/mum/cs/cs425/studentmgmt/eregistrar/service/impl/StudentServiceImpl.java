package edu.mum.cs.cs425.studentmgmt.eregistrar.service.impl;

import edu.mum.cs.cs425.studentmgmt.eregistrar.model.Student;
import edu.mum.cs.cs425.studentmgmt.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.eregistrar.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber);
        studentRepository.delete(student);
    }

    @Override
    public Student getStudentByStudentNumber(String studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

    @Override
    public void editStudent(Student student) {
        Student originalStudentInfo = studentRepository.findByStudentNumber(student.getStudentNumber());
        originalStudentInfo.setFirstName(student.getFirstName());
        originalStudentInfo.setMiddleName(student.getMiddleName());
        originalStudentInfo.setLastName(student.getLastName());
        originalStudentInfo.setCgpa(student.getCgpa());
        originalStudentInfo.setDateOfEnrollment(student.getDateOfEnrollment());
        originalStudentInfo.setIsInternational(student.getIsInternational());
        studentRepository.save(originalStudentInfo);
    }
}
