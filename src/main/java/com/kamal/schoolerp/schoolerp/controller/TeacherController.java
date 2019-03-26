package com.kamal.schoolerp.schoolerp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamal.schoolerp.schoolerp.entities.Teacher;
import com.kamal.schoolerp.schoolerp.services.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kamal.hossain1542 on 3/13/2019.
 */

@Controller
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void getTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "teacher/new", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("title", "New Teacher");
        model.addAttribute("buttonAction", "Submit");
        return "view/teacher/create";
    }

    @RequestMapping(value = "teacher/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("teachers", teacherService.listAllTeachers());
        return "view/teacher/list";
    }

    @RequestMapping("teacher/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        model.addAttribute("title", "Teacher Details");
        return "view/teacher/show";
    }

    @RequestMapping(value = "teacher/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestParam Map<String, Object> parameters) {
        Map<String, Object> result = new HashMap();
        Teacher teacher = new Teacher();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            teacher.setName(parameters.get("name").toString());
            teacher.setTeacherId(parameters.get("teacherId").toString());
            teacherService.saveTeacher(teacher);

            result.put("success", "true");
            result.put("message", "Teacher Saved Successfully");

            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            result.put("success", "false");
            result.put("message", "Teacher cannot be saved");
        }
        return "";
    }

    @RequestMapping(value = "teacher/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestParam Map<String, Object> parameters) {
        Map<String, Object> result = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();

        Teacher updateTeacher = teacherService.getTeacherById(Integer.parseInt(parameters.get("id").toString()));
        updateTeacher.setName(parameters.get("name").toString());
        updateTeacher.setTeacherId(parameters.get("teacherId").toString());

        try {
            teacherService.saveTeacher(updateTeacher);
            result.put("success", "true");
            result.put("message", "Teacher Updated Successfully");
            result.put("id", updateTeacher.getId());

            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            result.put("success", "false");
            result.put("message", "Teacher cannot be updated");
        }

        return "";
    }

    @RequestMapping("teacher/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "view/teacher/update";
    }

    @RequestMapping("teacher/delete/{id}")
    public String delete(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teacher/list";
    }
}
