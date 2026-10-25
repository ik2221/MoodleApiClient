package lt.viko.eif.repository;

import lt.viko.eif.dto.GradeItem;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface GradeItemRepository extends CrudRepository<GradeItem, Long> {
    List<GradeItem> findByItemName(String itemName);
    List<GradeItem> findByItemType(String itemType);
    List<GradeItem> findByItemModule(String itemModule);
    List<GradeItem> findByGradeRaw(int gradeRaw);
    List<GradeItem> findByGradeDateGraded(int gradeDateGraded);

    @Override
    @NullMarked
    @Join("userGrade") // <-- required to populate the MANY_TO_ONE side
    Optional<GradeItem> findById(Long id);
}
