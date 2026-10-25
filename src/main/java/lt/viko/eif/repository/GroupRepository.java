package lt.viko.eif.repository;

import lt.viko.eif.entity.Group;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.jspecify.annotations.NullMarked;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Override
    @NullMarked
    Optional<Group> findById(Long id);

    Optional<Group> findByMoodleGroupId(Long moodleGroupId);
}
