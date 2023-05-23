package cs3500.pa01.Study.Question;

import cs3500.pa01.Study.Difficulty;

/**
 * Represents a Question from the Study Guide
 */
public class Question {
  //fields
  private String question;
  private String answer;
  private Difficulty difficulty;

  /**
   * Constructor: Instantiates a question
   *
   * @param question question
   * @param answer answer
   * @param difficulty how hard the question is
   *
   */
  public Question(String question, String answer, Difficulty difficulty) {
    this.question = question;
    this.answer = answer;
    this.difficulty = difficulty;
  }

  /**
   * Gets this object's question
   *
   * @return String, the question
   */
  public String getQuestion() {
    return this.question;
  }

  /**
   * Gets this object's answer
   *
   * @return String, the answer
   */
  public String getAnswer() {
    return this.answer;
  }

  /**
   * Gets this object's difficulty
   *
   * @return String, the difficulty
   */
  public Difficulty getDifficulty() {

    return this.difficulty;
  }

  //make sure it is one of the enumerations probably
  public void setDifficulty(Difficulty diff) {

    this.difficulty = diff;
  }

  /**
   * Creates a string representation of the question's full metadata
   *
   * @return String, The questions full metadata (formatted): Question, Answer, Diff,
   */
  public String toString() {
    StringBuilder build = new StringBuilder();
    build.append(question + "\n");
    build.append(answer + "\n");
    build.append("Difficulty: "+ difficulty.toString() + "\n");
    return build.toString();
  }
}
