package kickstarter.model.dao.sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoriesDao;
import kickstarter.model.dao.ConnectionPool;

public class CategoriesDaoImpl implements CategoriesDao {

	Connection connection;

	public CategoriesDaoImpl(ConnectionPool connectionPool) {
		connection = connectionPool.getConnection();
	}

	@Override
	public List<Category> getAllCategories() {
		return getAllCategoriesWithCondition("");
	}

	@Override
	public Category getCategoryById(int categoryId) {
		String condition = " WHERE id = " + categoryId;
		Category result = getAllCategoriesWithCondition(condition).get(0);
		return result;
	}
	
	private List<Category> getAllCategoriesWithCondition(String condition) {
		String sqlQuery = "SELECT id, name FROM Categories" + condition + ";" ;
		List<Category> categories = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery(sqlQuery);
			while (rs.next()) {
				categories.add(new Category(rs.getInt("id"),
						rs.getString("name")
						)
				);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error while reading from DB", e);
		}
		return categories;
	}

}
