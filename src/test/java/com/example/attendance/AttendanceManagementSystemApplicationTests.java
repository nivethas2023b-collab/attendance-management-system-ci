package com.example.attendance;

import com.example.attendance.model.Attendance;
import com.example.attendance.service.AttendanceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendanceManagementSystemApplicationTests {

    private AttendanceService service = new AttendanceService();

    @Test
    void testPresenceValidation() {
        Attendance attendance = new Attendance(
                "Preethi",
                "2026-04-03",
                "Present"
        );

        assertEquals("Present", attendance.getStatus());
    }

    @Test
    void testAbsenceValidation() {
        Attendance attendance = new Attendance(
                "Preethi",
                "2026-04-03",
                "Absent"
        );

        assertEquals("Absent", attendance.getStatus());
    }

    @Test
    void testInvalidStatus() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Attendance attendance = new Attendance(
                            "Preethi",
                            "2026-04-03",
                            "Late"
                    );
                    service.markAttendance(attendance);
                }
        );

        assertTrue(exception.getMessage().contains("Invalid"));
    }
}