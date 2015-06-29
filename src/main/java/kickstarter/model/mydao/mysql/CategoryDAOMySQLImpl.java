package kickstarter.model.mydao.mysql;

import kickstarter.entities.Category;
import kickstarter.model.mydao.CategoryDAO;
import kickstarter.model.mydao.exceptions.DBException;
import kickstarter.utilities.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOMySQLImpl implements CategoryDAO {

    Connection connection;

    public CategoryDAOMySQLImpl(ConnectionPool connectionPool) {
        connection = connectionPool.getConnection();
    }

    @Override
    public List<Category> getAllCategories() throws DBException {
        return getAllCategoriesWithCondition("");
    }

    @Override
    public Category getCategoryById(int categoryId) throws DBException {
        String condition = " WHERE id = " + categoryId;
        return getAllCategoriesWithCondition(condition).get(0);
    }

    private List<Category> getAllCategoriesWithCondition(String condition) throws DBException {
        String sqlQuery = "SELECT `id`, `name` FROM `categories`" + condition + ";";
        List<Category> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"),
                                rs.getString("name")
                                )
                );
            }
        } catch (SQLException e) {
            throw new DBException("Error while reading from DB, table categories", e);
        }
        return categories;
    }

}

