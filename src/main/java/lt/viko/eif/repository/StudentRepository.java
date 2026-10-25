package lt.viko.eif.repository;

import lt.viko.eif.entity.Student;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.jspecify.annotations.NullMarked;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Override
    @NullMarked
    Optional<Student> findById(Long id);

    Optional<Student> findByMoodleUserId(Long moodleUserId);
}
