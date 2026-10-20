package lt.viko.eif;

import lt.viko.eif.dto.GradeItem;
import lt.viko.eif.repository.GradeItemRepository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class GradeItemRepositoryTest {

    @Inject
    GradeItemRepository gradeItemRepository;

    @Test
    void shouldSaveAndReadGradeItem() {
        // Save
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
                ""
        );
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
