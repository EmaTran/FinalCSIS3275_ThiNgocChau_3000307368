package com.studentfinal.entities;

import com.studentfinal.core.entities.IEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "studentrecord")
@DynamicUpdate
public class StudentRecord implements IEntity, Serializable {

    @Id
    @Column(name = "snumber")
    private String snumber;

    @Column(name = "sname")
    private String sname;

    @Column(name = "gpa")
    private float gpa;

    public StudentRecord() {
    }

    public String getStudentNumber() {
        return snumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.snumber = studentNumber;
    }

    public String getStudentName() {
        return sname;
    }

    public void setStudentName(String studentName) {
        this.sname = studentName;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
