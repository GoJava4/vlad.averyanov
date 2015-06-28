package kickstarter.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPoolMySQLImpl implements ConnectionPool{
    private static final String SQL_URL = "jdbc:mysql://tortik.asuscomm.com/vlad_averyanov";
    private static final String SQL_USER = "vlad_averyanov";
    private static final String SQL_PASSWORD = "vlad_averyanov";

    private Connection connection;

    public ConnectionPoolMySQLImpl() throws SQLException {
        try {
            Class.forName ("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    public void close() throws Exception {
        connection.close();
    }
}


