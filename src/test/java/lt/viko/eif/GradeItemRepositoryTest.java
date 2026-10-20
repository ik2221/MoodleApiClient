package lt.viko.eif;

import lt.viko.eif.dto.GradeItem;
import lt.viko.eif.dto.UserGrade;
import lt.viko.eif.repository.GradeItemRepository;
import lt.viko.eif.repository.UserGradeRepository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class GradeItemRepositoryTest {

    @Inject
    UserGradeRepository userGradeRepository;

    @Inject
    GradeItemRepository gradeItemRepository;

    @Test
    void shouldSaveAndReadGradeItem() {

        // Create a real parent first
        UserGrade userGradeMock = userGradeRepository.save(
                new UserGrade(null, 0, 0, "John Doe", null)
        );
        GradeItem gradeItemData = new GradeItem(
                null,
                "Test Grade 01",
                "manual",
                null,
                null,
                8,
                1,
                10,
                1791222617,
                "",
                userGradeMock // owning side sets the reference;
                // real parent, valid FK
        );

        // Save
        GradeItem savedGrade = gradeItemRepository.save(gradeItemData);
        assertNotNull(savedGrade.id());

        // Read back
        Optional<GradeItem> foundGrade = gradeItemRepository.findById(savedGrade.id());
        assertTrue(foundGrade.isPresent());
        assertEquals("Test Grade 01", foundGrade.get().itemName());
        assertEquals("manual", foundGrade.get().itemType());
        assertEquals(8, foundGrade.get().gradeRaw());
    }
}
