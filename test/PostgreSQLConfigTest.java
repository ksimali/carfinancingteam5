import static org.junit.Assert.*;

import Config.PostgreSQLConfig;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConfigTest {
    @Test
    public void testGetConnection() {
        try {
            Connection connection = PostgreSQLConfig.getConnection();
            assertNotNull(connection);
            assertFalse(connection.isClosed());
            connection.close(); // Fermer la connexion après l'avoir testée
        } catch (SQLException e) {
            fail("Erreur lors de l'obtention de la connexion : " + e.getMessage());
        }
    }

    @Test
    public void testInitializeDatabase() {
        try {
            Connection connection = PostgreSQLConfig.getConnection();
            assertNotNull(connection);

            PostgreSQLConfig.initializeDatabase();

            Statement stmt = connection.createStatement();
            assertTrue(stmt.execute("SELECT * FROM client"));
            assertTrue(stmt.execute("SELECT * FROM investor"));
            assertTrue(stmt.execute("SELECT * FROM financing"));
            assertTrue(stmt.execute("SELECT * FROM transaction"));
            assertTrue(stmt.execute("SELECT * FROM investment"));

            connection.close();
        } catch (SQLException e) {
            fail("Erreur lors de l'initialisation de la base de données : " + e.getMessage());
        }
    }
}