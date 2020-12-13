package com.studentfinal.tests;


import com.studentfinal.business.concrete.managers.StudentRecordManager;
import com.studentfinal.entities.StudentRecord;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class StudentRecordManagerTest {
    StudentRecordManager test = new StudentRecordManager();
    StudentRecord student = new StudentRecord();
    ModelMap modelMap = new ModelMap();
    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void add() {

        student.setGpa(2);
        student.setStudentName("Emma");
        student.setStudentNumber("1111");


        //     modelMap.addAttribute(user);
        test.add(student);
        assertTrue(true);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}