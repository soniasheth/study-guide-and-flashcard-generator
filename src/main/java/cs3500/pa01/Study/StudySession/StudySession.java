package cs3500.pa01.Study.StudySession;

import cs3500.pa01.Study.Question.Question;
import cs3500.pa01.Study.QuestionBank.StudySessionQuestionBank;
import java.util.ArrayList;

/**
 * Handles, tracks an individual study session + data
 * Holds everything needed for a Study Session
 */

public class StudySession {
  private int currQuestionIndex;
  private int numQuestionsAnswered;
  private int easyToHard;
  private int hardToEasy;
  private StudySessionQuestionBank questionBank;
  private ArrayList<Question> sessionQuestions;

  public StudySession(int numQuestions, String link) {
    questionBank = new StudySessionQuestionBank(link);
    this.sessionQuestions = questionBank.generateSessionQuestions(numQuestions);
    this.currQuestionIndex = 0;
    this.numQuestionsAnswered = 0;
    this.easyToHard = 0;
    this.hardToEasy = 0;
  }

  private void increaseQuestionIndex() {
    if(currQuestionIndex < sessionQuestions.size()) {
      currQuestionIndex++;
    }
    else {
      throw new RuntimeException("No more questions in this session's question bank.");
    }
  }

  public void processUserChoice(String input) {
    Question current = sessionQuestions.get(currQuestionIndex);
    switch(input) {
      //Marked as easy
      case "1":
        if(current.getDifficulty().equals("Hard")) {
          hardToEasy++;
          current.setDifficulty("Easy");
          questionBank.increaseNumEasyQue();
        }
        numQuestionsAnswered++;
        increaseQuestionIndex();
        break;
      //marked as hard
      case "2":
        if(current.getDifficulty().equals("Easy")) {
          easyToHard++;
          current.setDifficulty("Hard");
          questionBank.increaseNumHardQue();
        }
        numQuestionsAnswered++;
        increaseQuestionIndex();
        break;
      //requests answer
      case "3":
        numQuestionsAnswered++;
        increaseQuestionIndex();
        break;
      case "4":
        break;
      default:
        throw new IllegalArgumentException("Invalid Answer");
    }
  }

  public boolean done() {
    if(currQuestionIndex >= sessionQuestions.size()) {
      return true;
    }
    return false;
  }


  public String getCurrentQuestion() {
    return sessionQuestions.get(currQuestionIndex).getQuestion();
  }

  public String getCurrentAnswer() {
    return sessionQuestions.get(currQuestionIndex).getAnswer();
  }

  /**
   * Creates a String with all the session information
   *
   * @return a String will all the current session information
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("You answered " + numQuestionsAnswered + " questions\n" );
    builder.append(easyToHard + " questions" + "went from easy to hard\n");
    builder.append(hardToEasy + " questions" + "went from hard to easy\n");
    builder.append("Current Counts in Question Bank: \n");
    builder.append(questionBank.getNumHardQuestions() + " hard questions\n");
    builder.append(questionBank.getNumEasyQuestions() + " easy questions");
    return builder.toString();
  }

}
