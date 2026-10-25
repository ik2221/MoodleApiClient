package lt.viko.eif.repository;

import lt.viko.eif.entity.Attendance;
import lt.viko.eif.entity.AttendanceStatus;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    @Override
    @NullMarked
    Optional<Attendance> findById(Long id);

    List<Attendance> findByStudentId(Long studentId);
    List<Attendance> findBySessionId(Long sessionId);
    List<Attendance> findByStatus(AttendanceStatus status);
}
