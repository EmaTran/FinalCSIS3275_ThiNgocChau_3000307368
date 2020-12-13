package com.studentfinal.webUI.controllers;

import com.studentfinal.business.abstrct.IStudentRecordService;
import com.studentfinal.business.concrete.managers.StudentRecordManager;
import com.studentfinal.entities.StudentRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    private final IStudentRecordService _studentService;

    // TODO Dependency injection
    public HomeController() {
        this._studentService = new StudentRecordManager();
    }

    @RequestMapping(value = {"/", "/home", "/home/index"})
    public String index(Model model) {
        List<StudentRecord> studentRecords = _studentService.getAll();
        model.addAttribute("records", studentRecords);

        return "home/index";
    }

    @RequestMapping(value = "home/create")
    public String create() {
        return "home/createorupdate";
    }

    @RequestMapping(value = "home/update", params = {"studentNumber"})
    public String update(@RequestParam(value = "studentNumber") String studentNumber, Model model) {
        StudentRecord data = _studentService.getById(studentNumber);
        model.addAttribute("record", data);
        return "home/createorupdate";
    }

    @PostMapping(value = "/createorupdate")
    public @ResponseBody
    String ajaxcreateorupdate(HttpServletRequest request) {

        StudentRecord record = new StudentRecord();
        record.setStudentNumber(request.getParameter("studentNumber"));
        record.setStudentName(request.getParameter("studentName"));
        record.setGpa(Float.parseFloat(request.getParameter("gpa")));
        String studentNumber = request.getParameter("studentNumber");

        String msg, method;
        if (studentNumber == null || studentNumber.isEmpty()) {
            msg = _studentService.add(record) ? "OK" : "ERROR";
            method = "CREATE";
        } else {
            msg = _studentService.update(record) ? "OK" : "ERROR";
            method = "UPDATE";
        }
        return String.format("{\"msg\":\"%1s\", \"method\":\"%2s\"}", msg, method);
    }

    @PostMapping(value = "/delete")
    public @ResponseBody
    String ajaxpostdelete(HttpServletRequest request) {
        String studentNumber = request.getParameter("studentNumber");
        String msg = _studentService.deleteById(studentNumber) ? "OK" : "ERROR";
        return String.format("{\"msg\":\"%1s\"}", msg);
    }
}

