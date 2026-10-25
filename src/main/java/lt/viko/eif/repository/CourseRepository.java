package lt.viko.eif.repository;

import lt.viko.eif.entity.Course;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Override
    @NullMarked
    Optional<Course> findById(Long id);

    Optional<Course> findByMoodleCourseId(Long moodleCourseId);
    List<Course> findByFullname(String fullname);
    List<Course> findByShortname(String shortname);
}
