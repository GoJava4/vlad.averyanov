package kickstarter.model.dao.jdbctemplate.mappers;

import kickstarter.entities.Project;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet rs, int i) throws SQLException {
        return new Project(
                rs.getInt("id"),
                rs.getInt("category_id"),
                rs.getString("name"),
                rs.getString("short_description"),
                rs.getInt("money_goal"),
                rs.getInt("pledged"),
                rs.getInt("total_days"),
                new DateTime(rs.getDate("adding_date")),
                rs.getString("full_description"),
                rs.getString("link")
        );
    }

}
