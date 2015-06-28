package kickstarter.utilities;

import java.sql.Connection;

public interface ConnectionPool extends AutoCloseable {
	public Connection getConnection();
}
