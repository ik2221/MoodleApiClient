package lt.viko.eif;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TestContainersSmokeTest — test that TestContainers environment is OK.
 */
class TestContainersSmokeTest {

    @Test
    void postgresContainerStartsAndAcceptsQueries() throws Exception {
        try (PostgreSQLContainer<?> postgres =
                     new PostgreSQLContainer<>(DockerImageName.parse("postgres:17.11-alpine"))
        ) {
            postgres.start();

            assertTrue(postgres.isRunning(), "Container should be running");
            assertNotNull(postgres.getJdbcUrl(), "JDBC URL should be assigned");

            // Actually talk to the DB — proves it's not just a running process
            try (Connection conn = DriverManager.getConnection(
                    postgres.getJdbcUrl(),
                    postgres.getUsername(),
                    postgres.getPassword()
            );
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT 1")
            ) {
                assertTrue(rs.next());
                assertEquals(1, rs.getInt(1));
            }
        } // try-with-resources auto-stops the container
    }
}
