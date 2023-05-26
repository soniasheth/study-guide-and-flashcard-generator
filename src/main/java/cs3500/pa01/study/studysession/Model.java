package cs3500.pa01.study.studysession;

import cs3500.pa01.study.question.Question;
import java.util.ArrayList;

/**
 * Interface for the Model (Study Session)
 */
public interface Model {

  /**
   * Updates the bank + question field based on the user's answer to the question
   *
   * @param current the question being displayed
   * @param userChoice the choice the user chose
   */
  void markedQuestion(Question current, String userChoice);
  /**
   * Creates a String with all the session information
   *
   * @return a String will all the current session information
   */

  String toString();

  /**
   * Creates a String with all the questions in the whole question bank
   *
   * @return a String with all the questions in the whole question bank
   */
  String allQuestions();

  /**
   * Increases the number of questions answered by 1
   */

  void increaseQuestionsAnswered();
  /**
   * Initializes and returns the session questions
   *
   * @return the session questions
   */

  ArrayList<Question> initializeSessionQuestions(int numQuestions, String link);

  /**
   * Gets the number of questions switched from easy to hard - needed for testing
   *
   * @return number of questions switched from easy to hard
   */
  int getEasyToHard();

  /**
   * Gets the number of questions switched from hard to easy - needed for testing
   *
   * @return number of questions switched from hard to easy
   */
  int getHardToEasy();

  /**
   * Gets the number of questions answered in the session
   *
   * @return the number of questions answered in the session
   */
  int getNumQuestionsAnswered();
}
