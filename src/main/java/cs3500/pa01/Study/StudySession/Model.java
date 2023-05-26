package cs3500.pa01.Study.StudySession;

import cs3500.pa01.Study.Difficulty;
import cs3500.pa01.Study.Question.Question;
import java.util.ArrayList;

public interface Model {

  void markedQuestion(Question current, String userChoice);
  String toString();
  String allQuestions();

  public void increaseQuestionsAnswered();

  public ArrayList<Question> getSessionQuestions();


  int getEasyToHard();
  int getHardToEasy();
  int getNumQuestionsAnswered();
}
