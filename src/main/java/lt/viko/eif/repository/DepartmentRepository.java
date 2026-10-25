package lt.viko.eif.repository;

import lt.viko.eif.entity.Department;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    @Override
    @NullMarked
    Optional<Department> findById(Long id);

    List<Department> findByName(String name);
    Optional<Department> findByMoodleCategoryId(Long moodleCategoryId);
}
