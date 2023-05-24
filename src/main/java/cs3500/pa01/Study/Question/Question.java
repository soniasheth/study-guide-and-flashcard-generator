package cs3500.pa01.Study.Question;

import cs3500.pa01.CreateStudyGuides.MarkdownFile;
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
   * Constructor: Instantiates a Question
   *
   * @param question question
   * @param answer answer
   * @param difficulty how hard the question is (Difficulty Enum)
   *
   */
  public Question(String question, String answer, Difficulty difficulty) {
    this.question = question;
    this.answer = answer;
    this.difficulty = difficulty;
  }

  /**
   * Gets this Question's question
   *
   * @return String, the question
   */
  public String getQuestion() {
    return this.question;
  }

  /**
   * Gets this Questions's answer
   *
   * @return String, the answer
   */
  public String getAnswer() {
    return this.answer;
  }

  /**
   * Gets this object's Difficulty (enum)
   *
   * @return Difficulty Enum, the difficulty
   */
  public Difficulty getDifficulty() {

    return this.difficulty;
  }

  /**
   * Sets the difficulty to the given enum Difficulty parameter
   *
   * @param diff Difficulty enum type
   */
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

  /**
   * Overrides the equals method: Compares this Markdown file to another object
   * for equality
   *
   * @param other - an object to compare this Markdown file to
   * @return boolean whether this Markdown File is equal to the given one
   */

  public boolean equals(Object other) {
    if (!(other instanceof Question)) {
      throw new IllegalArgumentException("Not a Question");
    }
    Question that = (Question) other;
    return this.question.equals(that.question)
        && this.answer.equals(that.answer)
        && this.difficulty.equals(that.difficulty);
  }
}
