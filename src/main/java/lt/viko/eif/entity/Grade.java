package lt.viko.eif.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

import java.time.Instant;

@MappedEntity("grades")
public record Grade(
        @Id @GeneratedValue @MappedProperty("id") Long id,
        @MappedProperty("moodle_grade_item_id")   Long moodleGradeItemId,
        @MappedProperty("course_id")              Long courseId,
        @MappedProperty("student_id")             Long studentId,
        @MappedProperty("item_name")              String itemName,
        @MappedProperty("points")                 Double points,
        @MappedProperty("date_graded")            Instant dateGraded
) {
}
