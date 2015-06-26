package kickstarter.model.dao;

import java.util.List;
import java.util.Map;

import kickstarter.entities.Answer;
import kickstarter.entities.Project;
import kickstarter.entities.Question;

public interface QuestionsAndAnswersDao {
	
	Map<Question, List<Answer>> getAllQuestionsAndAnswers();
	
	Map<Question, List<Answer>> getQuestionsAndAnswersForProject(Project project);
	
	List<Answer> getAnswersForQuestion(Question question);
}
