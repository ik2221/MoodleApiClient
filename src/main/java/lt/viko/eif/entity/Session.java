package lt.viko.eif.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

import java.time.Instant;

@MappedEntity("sessions")
public record Session(
        @Id @GeneratedValue @MappedProperty("id") Long id,
        @MappedProperty("moodle_session_id")      Long moodleSessionId,
        @MappedProperty("moodle_attendance_id")   Long moodleAttendanceId,
        @MappedProperty("title")                  String title,
        @MappedProperty("session_date")           Instant sessionDate,
        @MappedProperty("group_id")               Long groupId
) {
}
