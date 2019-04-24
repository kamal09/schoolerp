package com.kamal.schoolerp.schoolerp.controller;

import com.kamal.schoolerp.schoolerp.entities.Student;
import com.kamal.schoolerp.schoolerp.services.student.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;

/**
 * Created by kamal.hossain1542 on 3/7/2019.
 */

@Controller
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "student/new", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("title", "New Student");
        model.addAttribute("buttonAction", "Submit");
        return "view/student/create";
    }

    @RequestMapping(value = "student/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("students", studentService.listAllStudents());
        return "view/student/list";
    }

    @RequestMapping("student/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("title", "Student Details");
        return "view/student/show";
    }

    @RequestMapping(value = "student/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student, BindingResult result) {
        studentService.saveStudent(student);
        return "redirect:/student/show/" + student.getId();
    }

    @RequestMapping(value = "student/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("student") Student student, BindingResult result) {
        Student updateStudent = studentService.getStudentById(student.getId());
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setFatherName(student.getFatherName());
        updateStudent.setMotherName(student.getMotherName());
        updateStudent.setStudentId(student.getStudentId());
        updateStudent.setGender(student.getGender());
        updateStudent.setDateOfBirth(student.getDateOfBirth());

        studentService.saveStudent(updateStudent);
        return "redirect:/student/show/" + student.getId();
    }

    @RequestMapping("student/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("dob", new SimpleDateFormat("dd/MM/yyyy").format(student.getDateOfBirth()));
        model.addAttribute("student", student);
        model.addAttribute("buttonAction", "Update");
        return "view/student/update";
    }

    @RequestMapping("student/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }

}
