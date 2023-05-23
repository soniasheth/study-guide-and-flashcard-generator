package cs3500.pa01.Study.StudySession;

import cs3500.pa01.Study.Difficulty;
import cs3500.pa01.Study.Question.Question;
import cs3500.pa01.Study.QuestionBank.StudySessionQuestionBank;
import java.util.ArrayList;

/**
 * Handles, tracks an individual study session + data
 * Holds everything needed for a Study Session
 */

public class StudySession {
  private int numQuestionsAnswered;
  private int easyToHard;
  private int hardToEasy;
  private StudySessionQuestionBank questionBank;
  private ArrayList<Question> sessionQuestions;

  public StudySession(int numQuestions, String link) {
    questionBank = new StudySessionQuestionBank(link);
    this.sessionQuestions = questionBank.generateSessionQuestions(numQuestions);
    this.numQuestionsAnswered = 0;
    this.easyToHard = 0;
    this.hardToEasy = 0;
  }

  public void increaseQuestionsAnswered() {
    numQuestionsAnswered++;
  }

  public ArrayList<Question> getSessionQuestions() {
    return sessionQuestions;
  }

  public void markQuestion(Question current, String choice) {
    //if the current question is currently easy and the user wants to mark it as hard
    if(current.getDifficulty().equals(Difficulty.EASY) && choice.equals("1")) {
      hardToEasy++;
      current.setDifficulty(Difficulty.EASY);
      questionBank.increaseNumEasyQue();
    }
    else if(current.getDifficulty().equals(Difficulty.HARD) && choice.equals("2")) {
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
    builder.append("You answered " + numQuestionsAnswered + " questions\n" );
    builder.append(easyToHard + " questions" + " went from easy to hard\n");
    builder.append(hardToEasy + " questions" + " went from hard to easy\n");
    builder.append("Current Counts in Question Bank: \n");
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

}
