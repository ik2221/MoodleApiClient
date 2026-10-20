package lt.viko.eif.dto;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.GeneratedValue;

@MappedEntity("users")
public record User(
        @Id @GeneratedValue Long id,
        String firstName,
        String lastName,
        String email
) {
}
