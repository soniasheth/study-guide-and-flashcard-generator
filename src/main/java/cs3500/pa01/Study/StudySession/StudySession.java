package cs3500.pa01.Study.StudySession;

import cs3500.pa01.Study.Difficulty;
import cs3500.pa01.Study.Question.Question;
import cs3500.pa01.Study.QuestionBank.StudySessionQuestionBank;
import java.util.ArrayList;
import java.util.Random;

/**
 * Handles, tracks an individual study session + data
 * Holds everything needed for a Study Session
 *
 * MODEL
 */

public class StudySession implements Model{
  private int numQuestionsAnswered;
  private int easyToHard;
  private int hardToEasy;
  private StudySessionQuestionBank questionBank;
  private ArrayList<Question> sessionQuestions;

  public StudySession(int numQuestions, String link) {
    questionBank = new StudySessionQuestionBank(link);
    this.sessionQuestions = questionBank.generateSessionQuestions(numQuestions, new Random().nextInt());
    this.numQuestionsAnswered = 0;
    this.easyToHard = 0;
    this.hardToEasy = 0;
  }

  public void markedQuestion(Question current, String userChoice) {
    if(current.getDifficulty().equals(Difficulty.HARD) && userChoice.equals("easy")) {
      hardToEasy++;
      current.setDifficulty(Difficulty.EASY);
      questionBank.increaseNumEasyQue();
    }
    else if(current.getDifficulty().equals(Difficulty.EASY) && userChoice.equals("hard")) {
      easyToHard++;
      current.setDifficulty(Difficulty.HARD);
      questionBank.increaseNumHardQue();
    }
    increaseQuestionsAnswered();
  }

  /**
   * Creates a String with all the session information
   *
   * @return a String will all the current session information
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Total questions answered: " + numQuestionsAnswered + "\n" );
    builder.append("Questions from easy to hard: " + easyToHard + "\n");
    builder.append("Questions from hard to easy: "+ hardToEasy + "\n");
    builder.append("Current Counts in Question Bank:\n");
    builder.append(questionBank.getNumHardQuestions() + " hard questions\n");
    builder.append(questionBank.getNumEasyQuestions() + " easy questions");
    return builder.toString();
  }

  /**
   * Creates a String with all the questions in the whole question bank
   *
   * @return a String with all the questions in the whole question bank
   */
  public String allQuestions() {
    return questionBank.toString();
  }

  public void increaseQuestionsAnswered() {
    numQuestionsAnswered++;
  }

  public ArrayList<Question> getSessionQuestions() {
    return sessionQuestions;
  }


  public int getEasyToHard() {
    return easyToHard;
  }
  public int getHardToEasy() {
    return hardToEasy;
  }
  public int getNumQuestionsAnswered() {
    return numQuestionsAnswered;
  }

}
