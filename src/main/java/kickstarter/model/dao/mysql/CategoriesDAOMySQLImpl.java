package kickstarter.model.dao.mysql;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectsDAO;
import kickstarter.model.exceptions.DBException;
import kickstarter.utilities.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOMySQLImpl implements ProjectsDAO {

    Connection connection;

    public CategoriesDAOMySQLImpl(ConnectionPool connectionPool) {
        connection = connectionPool.getConnection();
    }

    @Override
    public List<Project> getAllProjects() throws DBException {
        return getAllProjectsWithCondition("");
    }

    @Override
    public List<Project> getAllProjectsOfCategory(int categoryId) throws DBException {
        String condition = " WHERE category_id = " + categoryId;
        return getAllProjectsWithCondition(condition);
    }

    private List<Project> getAllProjectsWithCondition(String condition) throws DBException {
        String sqlQuery = "SELECT id, category_id, name, short_description, money_goal, pledged, "
                + "days_to_go, full_description, link FROM projects" + condition + ";";
        List<Project> projects = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement
                    .executeQuery(sqlQuery);
            while (rs.next()) {
                projects.add(new Project(rs.getInt("id"),
                                rs.getInt("category_id"),
                                rs.getString("name"),
                                rs.getString("short_description"),
                                rs.getInt("money_goal"),
                                rs.getInt("pledged"),
                                rs.getInt("days_to_go"),
                                rs.getString("full_description"),
                                rs.getString("link"),
                                "Q: A:")
                );
            }
        } catch (SQLException e) {
            throw new DBException("Error while reading from DB, table projects", e);
        }
        return projects;
    }

}

