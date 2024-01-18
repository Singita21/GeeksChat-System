package com.Project.SpringAngular.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "student_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;


    @Column(name = "student_name", length = 50)
    private String studentName;
    @Column(name = "student_email", length = 60)
    private String studentEmail;
    @Column(name = "student_mobile", length = 13)
    private String mobile;

    public Student(int studentId,String studentName, String studentEmail, String mobile) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.mobile = mobile;
    }

    public Student() {
    }

    public Student(String studentName, String studentEmail, String mobile) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.mobile = mobile;
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", mobile=" + mobile +
                '}';
    }



}
