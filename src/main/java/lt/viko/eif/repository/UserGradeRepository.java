package lt.viko.eif.repository;

import lt.viko.eif.dto.UserGrade;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.H2)
public interface UserGradeRepository extends CrudRepository<UserGrade, Long> {

    /*
        The @Join is required because Micronaut Data JDBC
        does not automatically load associations; without
        it, gradeItems will be null or empty.
     */
    @Join(value = "gradeItems", type = Join.Type.LEFT_FETCH)
    Optional<UserGrade> getById(Long id);
}
