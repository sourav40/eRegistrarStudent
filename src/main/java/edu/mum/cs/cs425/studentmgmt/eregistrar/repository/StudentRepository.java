package edu.mum.cs.cs425.studentmgmt.eregistrar.repository;

import edu.mum.cs.cs425.studentmgmt.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentNumber(String studentNumber);
}
