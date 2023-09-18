package edu.mum.cs.cs425.studentmgmt.eregistrar.controller;

import edu.mum.cs.cs425.studentmgmt.eregistrar.model.Student;
import edu.mum.cs.cs425.studentmgmt.eregistrar.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public ModelAndView studentList() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.getStudentList();
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("/student/list");
        return modelAndView;
    }

    @GetMapping("/addPage")
    public ModelAndView addPage() {
        Map<String, Object> params = new HashMap<>();
        params.put("student", new Student());
        return new ModelAndView("/student/addStudent", params);
    }

    @PostMapping(value = "/add")
    public ModelAndView addStudent(@ModelAttribute("student") @Valid Student student) {
        studentService.addStudent(student);
        return new ModelAndView("redirect:/student/list");
    }

    @PostMapping("/delete")
    public ModelAndView deleteStudent(@RequestParam("studentNumber") String studentNumber) {
        studentService.deleteStudent(studentNumber);
        return new ModelAndView("redirect:/student/list");
    }

    @GetMapping("/editPage")
    public ModelAndView editPage(@RequestParam("studentNumber") String studentNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("student", studentService.getStudentByStudentNumber(studentNumber));
        return new ModelAndView("/student/editStudent", params);
    }

    @PostMapping("/edit")
    public ModelAndView editStudent(@ModelAttribute("student") @Valid Student student) {
        studentService.editStudent(student);
        return new ModelAndView("redirect:/student/list");
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("studentNumber") String studentNumber) {
        ModelAndView modelAndView = new ModelAndView();
        Student studentList = studentService.getStudentByStudentNumber(studentNumber);
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("/student/list");
        return modelAndView;
    }

}
