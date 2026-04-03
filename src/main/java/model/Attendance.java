package com.example.attendance.model;

import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String date;
    private String status; // Present / Absent

    public Attendance() {}

    public Attendance(String studentName, String date, String status) {
        this.studentName = studentName;
        this.date = date;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getDate() { return date; }
    public String getStatus() { return status; }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}