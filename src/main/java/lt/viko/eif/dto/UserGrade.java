package lt.viko.eif.dto;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Relation;

import java.util.List;

@MappedEntity("user_grades")
public record UserGrade(
        @Id @GeneratedValue Long id,
        int courseId,
        int userId,
        String userFullName,

        // One UserGrade -> Many GradeItems
        // NOTE:
        //   * mappedBy references a Java record field name, not database field name
        //   * the "owning side" of the relation is in the GradeItem, not here
        @Nullable
        @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "userGrade")
        List<GradeItem> gradeItems
) {
}
