package cs3500.pa01.Study.QuestionBank;

import cs3500.pa01.Study.Question.Question;
import java.util.ArrayList;

/**
 * Handles creating question banks for a Study Session
 */
public abstract class QuestionBank {
  //fields
  protected String link;
  protected ArrayList<Question> allQuestions;

  /**
   * Instantiates AbstractQuestionBank
   *
   * @param link link to the .sr file with the question
   *
   */
  QuestionBank(String link) {
    this.link = link;
    this.allQuestions = new ArrayList<>();
  }


  /**
   * Reads the file of questions and generates bank(s) of questions to pull from
   *     adds questions to ArrayList (s) of questions
   *
   */
  public abstract void initializeQuestions();

  /**
   * Creates an ArrayList with randomized questions for a study session
   *
   * @param questionNum the amount of questions wanted for the session
   * @return an ArrayList full of the chosen questions just for one session
   *
   */
  public abstract ArrayList<Question> generateSessionQuestions(int questionNum, int seed);

  public ArrayList<Question> getAllQuestions() {
    return this.allQuestions;
  }

  /**
   * Creates a string representation of all the questions in the file
   *
   * @return String with all the questions, answers, and difficulty
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(Question x : allQuestions) {
      builder.append(x.toString() + "\n");
    }
    return builder.toString();
  }
}
