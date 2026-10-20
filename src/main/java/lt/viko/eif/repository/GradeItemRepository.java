package lt.viko.eif.repository;

import lt.viko.eif.dto.GradeItem;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface GradeItemRepository extends CrudRepository<GradeItem, Long> {
    List<GradeItem> findByItemName(String itemName);
    List<GradeItem> findByItemType(String itemType);
    List<GradeItem> findByItemModule(String itemModule);
    List<GradeItem> findByGradeRaw(int gradeRaw);
    List<GradeItem> findByGradeDateGraded(int gradeDateGraded);
}
