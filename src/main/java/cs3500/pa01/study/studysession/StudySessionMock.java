package cs3500.pa01.study.studysession;

import cs3500.pa01.study.Difficulty;
import cs3500.pa01.study.question.Question;
import java.util.ArrayList;

/**
 * Represents a Mock Class of the Study Session
 */
public class StudySessionMock implements Model {

  public StringBuilder build;

  public StudySessionMock() {
    build = new StringBuilder();
  }

  /**
   * Updates the bank + question field based on the user's answer to the question
   *
   * @param current the question being displayed
   * @param userChoice the choice the user chose
   */
  @Override
  public void markedQuestion(Question current, String userChoice) {
    build.append("markedQuestion ");

  }

  /**
   * Creates a String with all the questions in the whole question bank
   *
   * @return a String with all the questions in the whole question bank
   */
  @Override
  public String allQuestions() {
    build.append("allQuestions ");
    return "hello";
  }

  /**
   * Increases the number of questions answered by 1
   */
  @Override
  public void increaseQuestionsAnswered() {
    build.append("increase ");

  }

  /**
   * Initializes and returns the session questions
   *
   * @return the session questions
   */
  @Override
  public ArrayList<Question> initializeSessionQuestions(int numQuestions, String link) {
    Question test = new Question("Hello", "Goodbye", Difficulty.EASY);
    ArrayList<Question> tester = new ArrayList<>();
    tester.add(test);
    build.append("init ");
    return tester;
  }

  /**
   * Gets the number of questions switched from easy to hard - needed for testing
   *
   * @return number of questions switched from easy to hard
   */
  @Override
  public int getEasyToHard() {
    build.append("easytohard ");
    return 0;
  }

  /**
   * Gets the number of questions switched from hard to easy - needed for testing
   *
   * @return number of questions switched from hard to easy
   */
  @Override
  public int getHardToEasy() {
    build.append("hardtoeasy ");
    return 0;
  }

  /**
   * Gets the number of questions answered in the seesion
   *
   * @return the number of questions answered in the session
   */
  @Override
  public int getNumQuestionsAnswered() {
    build.append("numquestions ");
    return 0;
  }

}
