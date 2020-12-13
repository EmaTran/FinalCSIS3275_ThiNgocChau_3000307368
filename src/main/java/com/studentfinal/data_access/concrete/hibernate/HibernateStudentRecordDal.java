package com.studentfinal.data_access.concrete.hibernate;

import com.studentfinal.core.data_access.hibernate.HibernateEntityRepositoryBase;
import com.studentfinal.data_access.abstrct.IStudentRecordDal;
import com.studentfinal.entities.StudentRecord;

public class HibernateStudentRecordDal extends HibernateEntityRepositoryBase<StudentRecord> implements IStudentRecordDal {
    public HibernateStudentRecordDal(Class<StudentRecord> studentRecordClass) {
        super(studentRecordClass);
    }
}
