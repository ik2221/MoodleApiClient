package lt.viko.eif;

import io.micronaut.context.annotation.Context;
import jakarta.annotation.PreDestroy;
import org.h2.tools.Server;

import java.sql.SQLException;

@Context
public class H2TcpServer {
    private final Server server;

    public H2TcpServer() throws SQLException {
        /*
            Starts a TCP server on localhost, default port 9092.

            WARNING
            -------
            The "-tcpAllowOthers" flag allows any process on your
            machine to connect to the H2 server. For local
            development this is fine, but never use this
            configuration in production. If you only need to
            connect from the Console running on the same machine,
            you can omit the "-tcpAllowOthers" flag; the default is
            to allow only local connections.
         */
        server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
        System.out.println("H2 TCP server started on port 9092");
    }

    @PreDestroy
    public void stop() {
        if (server != null) {
            server.stop();
        }
    }
}
