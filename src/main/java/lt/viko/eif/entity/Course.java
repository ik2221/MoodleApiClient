package lt.viko.eif.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity("courses")
public record Course(
        @Id @GeneratedValue @MappedProperty("id") Long id,
        @MappedProperty("moodle_course_id")       Long moodleCourseId,
        @MappedProperty("fullname")               String fullname,
        @MappedProperty("shortname")              String shortname,
        @MappedProperty("department_id")          Long departmentId
) {
}
