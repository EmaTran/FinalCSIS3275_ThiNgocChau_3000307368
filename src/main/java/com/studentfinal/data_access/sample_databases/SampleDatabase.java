package com.studentfinal.data_access.sample_databases;

import com.github.javafaker.Faker;
import com.studentfinal.business.abstrct.IStudentRecordService;
import com.studentfinal.business.concrete.managers.StudentRecordManager;
import com.studentfinal.entities.StudentRecord;

public class SampleDatabase {

    public static void initializeDatabase() {
        IStudentRecordService studentService = new StudentRecordManager();
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            StudentRecord student = new StudentRecord();
            student.setStudentNumber(faker.numerify("#####"));
            student.setStudentName(faker.name().fullName());
            student.setGpa((float) faker.number().randomDouble(2, 3, 4));
            studentService.add(student);
        }
    }
}
