package com.studentfinal.business.concrete.managers;

import com.studentfinal.business.abstrct.IStudentRecordService;
import com.studentfinal.data_access.abstrct.IStudentRecordDal;
import com.studentfinal.data_access.concrete.hibernate.HibernateStudentRecordDal;
import com.studentfinal.entities.StudentRecord;

import java.util.List;

public class StudentRecordManager implements IStudentRecordService {

    private IStudentRecordDal _studentRecordDal;

    public StudentRecordManager() {
        this._studentRecordDal = new HibernateStudentRecordDal(StudentRecord.class);
    }

    @Override
    public List<StudentRecord> getAll() {
        return _studentRecordDal.getAll();
    }

    @Override
    public StudentRecord getById(String studentId) {
        return _studentRecordDal.getById(studentId);
    }

    @Override
    public boolean add(StudentRecord customer) {
        return _studentRecordDal.add(customer);
    }

    @Override
    public boolean update(StudentRecord customer) {
        return _studentRecordDal.update(customer);
    }

    @Override
    public boolean deleteById(String studentId) {

        return _studentRecordDal.delete(getById(studentId));
    }
}
