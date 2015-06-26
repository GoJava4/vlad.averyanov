package kickstarter.control;

import java.sql.SQLException;

import kickstarter.model.dao.ConnectionPoolImpl;
import kickstarter.model.dao.Dao;
import kickstarter.model.dao.DaoImpl;
import kickstarter.view.ConsoleReader;
import kickstarter.view.ConsoleWriter;
import kickstarter.view.Reader;
import kickstarter.view.Writer;

public class KickstarterRunner {

	public static void main(String[] args) throws SQLException {
		Reader reader = new ConsoleReader();
		Writer writer = new ConsoleWriter();
		Dao genericDao = new DaoImpl(new ConnectionPoolImpl());
		
		DataIOTypeStorage dataIOTypeStorage = new DataIOTypeStorage(reader, writer);
		Kickstarter kickstarter = new Kickstarter(dataIOTypeStorage, genericDao);
		kickstarter.run();
	}

}
