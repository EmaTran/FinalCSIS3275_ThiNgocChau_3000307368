package com.studentfinal.business.abstrct;

import com.studentfinal.entities.StudentRecord;

import java.util.List;

public interface IStudentRecordService {

    List<StudentRecord> getAll();

    StudentRecord getById(String studentNumber);

    boolean add(StudentRecord customer);

    boolean update(StudentRecord customer);

    boolean deleteById(String studentNumber);
}
