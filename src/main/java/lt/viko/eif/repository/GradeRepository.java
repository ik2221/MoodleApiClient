package lt.viko.eif.repository;

import lt.viko.eif.entity.Grade;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface GradeRepository extends CrudRepository<Grade, Long> {

    @Override
    @NullMarked
    Optional<Grade> findById(Long id);

    List<Grade> findByMoodleGradeItemId(Long moodleGradeItemId);
    List<Grade> findByItemName(String itemName);
}
