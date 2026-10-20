package lt.viko.eif;

import lt.viko.eif.dto.GradeItem;
import lt.viko.eif.dto.UserGrade;
import lt.viko.eif.repository.GradeItemRepository;
import lt.viko.eif.repository.UserGradeRepository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class UserGradeRepositoryTest {

    @Inject
    UserGradeRepository userGradeRepository;

    @Inject
    GradeItemRepository gradeItemRepository;

    @Test
    void shouldLinkGradeItemsToUserGrade() {
        // 1. Save the parent
        UserGrade userGrade = userGradeRepository.save(
                new UserGrade(null, 1, 42, "John Doe", null)
        );
        assertNotNull(userGrade.id());

        // 2. Save two children, each pointing at the parent
        GradeItem item1 = gradeItemRepository.save(new GradeItem(
                null, "Test Grade 01", "manual", null, null,
                8, 1, 10, 1791222617, "", userGrade));
        GradeItem item2 = gradeItemRepository.save(new GradeItem(
                null, "Test Grade 02", "manual", null, null,
                9, 1, 10, 1791222618, "great", userGrade));

        assertNotNull(item1.id());
        assertNotNull(item2.id());

        // 3. Reload the parent WITH the @Join — this is what populates gradeItems
        UserGrade reloaded = userGradeRepository.getById(userGrade.id()).orElseThrow();

        // 4. Verify the relationship
        assertNotNull(reloaded.gradeItems());
        assertEquals(2, reloaded.gradeItems().size()); // expected: 2, actual: 0

        List<String> names = reloaded.gradeItems().stream()
                .map(GradeItem::itemName)
                .toList();
        assertTrue(names.contains("Test Grade 01"));
        assertTrue(names.contains("Test Grade 02"));

        // 5. Verify the owning side points back correctly
        GradeItem fetchedItem = gradeItemRepository.findById(item1.id()).orElseThrow();
        assertNotNull(fetchedItem.userGrade());
        assertEquals(userGrade.id(), fetchedItem.userGrade().id());
    }
}
