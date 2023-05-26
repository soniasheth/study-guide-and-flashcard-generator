package cs3500.pa01.Study.StudySession;

import cs3500.pa01.Study.Difficulty;
import cs3500.pa01.Study.Question.Question;
import java.util.ArrayList;

/**
 * Interface for the Model (Study Session)
 */
public interface Model {
  void markedQuestion(Question current, String userChoice);
  String toString();
  String allQuestions();
  void increaseQuestionsAnswered();
  ArrayList<Question> initializeSessionQuestions(int numQuestions, String link);
  int getEasyToHard();
  int getHardToEasy();
  int getNumQuestionsAnswered();
}
