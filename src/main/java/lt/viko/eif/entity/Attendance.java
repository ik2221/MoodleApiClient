package lt.viko.eif.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity("attendance")
public record Attendance(
        @Id @GeneratedValue @MappedProperty("id") Long id,
        @MappedProperty("student_id")             Long studentId,
        @MappedProperty("session_id")             Long sessionId,
        @MappedProperty("status")                 AttendanceStatus status
) {
}
