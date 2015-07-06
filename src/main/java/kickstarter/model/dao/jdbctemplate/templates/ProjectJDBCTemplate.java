package kickstarter.model.dao.jdbctemplate.templates;

import kickstarter.entities.Project;
import kickstarter.model.dao.ProjectDAO;
import kickstarter.model.dao.jdbctemplate.mappers.ProjectMapper;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProjectJDBCTemplate implements ProjectDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

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
        return jdbcTemplateObject.query(sql, new ProjectMapper());
    }

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
        jdbcTemplateObject.queryForObject(sql, args, new ProjectMapper());
     }

    @Override
    public void delete(Project entity) {
        String sql = "DELETE FROM projects WHERE id = ?";
        Object[] args = {
                entity.getId()
        };
        jdbcTemplateObject.update(sql, args);
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
        jdbcTemplateObject.update(sql, args);
    }
}
