package lt.viko.eif.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity("students")
public record Student(
        @Id @GeneratedValue @MappedProperty("id") Long id,
        @MappedProperty("moodle_user_id")         Long moodleUserId,
        @MappedProperty("first_name")             String firstName,
        @MappedProperty("last_name")              String lastName,
        @MappedProperty("group_id")               Long groupId
) {
}
