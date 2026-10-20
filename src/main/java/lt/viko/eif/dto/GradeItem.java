package lt.viko.eif.dto;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.sql.JoinColumn;

@MappedEntity("grade_items")
public record GradeItem (
        @Id @GeneratedValue Long id,
        String itemName,
        String itemType,
        @Nullable String itemModule,
        @Nullable Integer itemInstance,

        int gradeRaw,
        int gradeMin,
        int gradeMax,

        int gradeDateGraded,
        String feedback,

        /*
            1. This is the "owning side" of a bidirectional table relation.
            2. The owning side sets the .userGrade reference.
            3. JoinColumn specifies the foreign-key column explicitly.
               Micronaut data can infer it, but this is safer.

            TL;DR: the child owns the relationship, the parent only mirrors it.
            Always set GradeItem.userGrade when linking a grade item to a user
            grade, and save the child.
         */
        @Nullable
        @Relation(Relation.Kind.MANY_TO_ONE)
        @JoinColumn(name = "user_grade_id")
        UserGrade userGrade
) {
}
