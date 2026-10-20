package lt.viko.eif;

import lt.viko.eif.dto.User;
import lt.viko.eif.repository.UserRepository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class UserRepositoryTest {

    @Inject
    UserRepository userRepository;

    @Test
    void shouldSaveAndReadUser() {
        // Save
        User saved = userRepository.save(new User(
                null,
                "John",
                "Doe",
                "j.doe@mail.xyz")
        );
        assertNotNull(saved.id());

        // Read back
        Optional<User> found = userRepository.findById(saved.id());
        assertTrue(found.isPresent());
        assertEquals("John", found.get().firstName());
        assertEquals("j.doe@mail.xyz", found.get().email());
    }
}
