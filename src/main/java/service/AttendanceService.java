package com.example.attendance.service;

import com.example.attendance.model.Attendance;
import com.example.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    public Attendance markAttendance(Attendance attendance) {

        if (!attendance.getStatus().equalsIgnoreCase("Present") &&
                !attendance.getStatus().equalsIgnoreCase("Absent")) {
            throw new IllegalArgumentException("Invalid attendance status");
        }

        return repository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }
}