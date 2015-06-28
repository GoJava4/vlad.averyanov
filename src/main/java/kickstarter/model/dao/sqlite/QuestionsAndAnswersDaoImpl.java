package kickstarter.model.dao.sqlite;

import java.util.List;
import java.util.Map;

import kickstarter.entities.Answer;
import kickstarter.entities.Project;
import kickstarter.entities.Question;
import kickstarter.model.dao.ConnectionPool;
import kickstarter.model.dao.QuestionsAndAnswersDao;

public class QuestionsAndAnswersDaoImpl implements QuestionsAndAnswersDao {

	public QuestionsAndAnswersDaoImpl(ConnectionPool connectionPool) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<Question, List<Answer>> getAllQuestionsAndAnswers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Question, List<Answer>> getQuestionsAndAnswersForProject(
			Project project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> getAnswersForQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

}
