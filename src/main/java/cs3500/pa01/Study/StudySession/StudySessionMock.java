package cs3500.pa01.Study.StudySession;

import cs3500.pa01.Study.Difficulty;
import cs3500.pa01.Study.Question.Question;
import java.io.IOException;
import java.util.ArrayList;

public class StudySessionMock implements Model {

  public StringBuilder build;

  public StudySessionMock(){
     build = new StringBuilder();
  }

  @Override
  public void markedQuestion(Question current, String userChoice) {
    build.append("markedQuestion ");

  }
  @Override
  public String allQuestions() {
    build.append("allQuestions ");
    return "hello";
  }

  @Override
  public void increaseQuestionsAnswered() {
    build.append("increase ");

  }

  @Override
  public ArrayList<Question> initializeSessionQuestions(int numQuestions, String link) {
    Question test = new Question("Hello", "Goodbye", Difficulty.EASY);
    ArrayList<Question> tester = new ArrayList<>();
    tester.add(test);
    build.append("init ");
    return tester;
  }

  @Override
  public int getEasyToHard() {
    build.append("easytohard ");
    return 0;
  }

  @Override
  public int getHardToEasy() {
    build.append("hardtoeasy ");
    return 0;
  }

  @Override
  public int getNumQuestionsAnswered() {
    build.append("numquestions ");
    return 0;
  }

}
