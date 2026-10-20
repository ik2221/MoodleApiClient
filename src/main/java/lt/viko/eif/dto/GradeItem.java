package lt.viko.eif.dto;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.core.annotation.Nullable;

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
        String feedback
) {
}
