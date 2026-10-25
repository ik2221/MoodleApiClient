package lt.viko.eif.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity("departments")
public record Department(
        @Id @GeneratedValue @MappedProperty("id") Long id,
        @MappedProperty("name")                   String name,
        @MappedProperty("moodle_category_id")     Long moodleCategoryId
) {
}
