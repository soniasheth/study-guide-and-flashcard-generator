package cs3500.pa01.Study.StudySession;

import cs3500.pa01.Study.Question.Question;
import java.util.ArrayList;

public class StudySessionMock implements Model {
  @Override
  public void markedQuestion(Question current, String userChoice) {

  }

  @Override
  public String allQuestions() {
    return null;
  }

  @Override
  public void increaseQuestionsAnswered() {

  }

  @Override
  public ArrayList<Question> getSessionQuestions() {
    return null;
  }

  @Override
  public int getEasyToHard() {
    return 0;
  }

  @Override
  public int getHardToEasy() {
    return 0;
  }

  @Override
  public int getNumQuestionsAnswered() {
    return 0;
  }
}
