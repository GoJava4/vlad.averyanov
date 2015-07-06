package kickstarter.model.dao.templates;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectDAO;
import kickstarter.model.dao.mappers.ProjectMapper;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProjectJDBCTemplate implements ProjectDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Project> getAllProjects() {
        return getAllProjectsWithCondition("");
    }

    @Override
    public List<Project> getAllProjectsOfCategory(int categoryId) {
        String condition = " WHERE category_id = " + categoryId;
        return getAllProjectsWithCondition(condition);
    }

    private List<Project> getAllProjectsWithCondition(String condition) {
        String sql = "SELECT `id`, `category_id`, `name`, `short_description`, `money_goal`, `pledged`, "
                + "`total_days`, `adding_date`, `full_description`, `link` FROM `projects`" + condition;
        return jdbcTemplate.query(sql, new ProjectMapper());
    }

    @Override
    public Project selectById(Integer id) {
        String condition = " WHERE id = " + id;
        return getAllProjectsWithCondition(condition).get(0);
    }

    @Override
    public void create(Project entity) {
        String sql = "INSERT INTO projects (`category_id`, `name`, `short_description`, `money_goal`, `pledged`, " +
                "`total_days`, `adding_date`, `full_description`, `link`) VALUE " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = {
                entity.getCategoryId(),
                entity.getName(),
                entity.getShortDescription(),
                entity.getMoneyGoal(),
                entity.getPledged(),
                entity.getTotalDays(),
                new DateTime(entity.getAddingDate()),
                entity.getFullDescription(),
                entity.getLink()
        };
        jdbcTemplate.update(sql, args);
     }

    @Override
    public void delete(Project entity) {
        String sql = "DELETE FROM projects WHERE id = ?";
        Object[] args = {
                entity.getId()
        };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(Project entity) {
        String sql = "UPDATE projects SET `category_id` = ?, `name` = ?, `short_description` = ?, `money_goal` = ?," +
                "`pledged` = ?, `total_days` = ?, `adding_date` = ?, `full_description` = ?, `link` = ?" +
                " WHERE id = ?";
        Object[] args = {
                entity.getCategoryId(),
                entity.getName(),
                entity.getShortDescription(),
                entity.getMoneyGoal(),
                entity.getPledged(),
                entity.getTotalDays(),
                new DateTime(entity.getAddingDate()),
                entity.getFullDescription(),
                entity.getLink()
        };
        jdbcTemplate.update(sql, args);
    }
}
