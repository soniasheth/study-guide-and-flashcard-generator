package cs3500.pa01.Study.Question;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa01.LineProcessor;
import cs3500.pa01.Study.Difficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Question Class
 */
class QuestionTest {
  //fields
  Question q1;
  Question q2;

  /**
   * Initializes objects needed for the testing
   */
  @BeforeEach
  public void setUp() {
    q1 = new Question("Where is Seattle located?", "Answer: Washington State", Difficulty.HARD);
    q2 = new Question("Where is Kirkland?", "Answer: Eastside of Seattle", Difficulty.EASY);
  }

  /**
   * Tests the getQuesion method
   */
  @Test
  public void testGetQuestion() {
    assertEquals("Where is Seattle located?", q1.getQuestion());
    assertEquals("Where is Kirkland?", q2.getQuestion());
  }

  /**
   * Tests the getAnswer() method
   */
  @Test
  public void testGetAnswer() {
    assertEquals("Answer: Washington State", q1.getAnswer());
    assertEquals("Answer: Eastside of Seattle", q2.getAnswer());
  }

  /**
   * Tests the getDifficulty method
   */
  @Test
  public void testGetDifficulty() {
    assertEquals(Difficulty.HARD, q1.getDifficulty());
    assertEquals(Difficulty.EASY, q2.getDifficulty());
  }

  /**
   * Tests the setDifficulty  method
   */
  @Test
  public void testSetDifficulty() {
    assertEquals(Difficulty.HARD, q1.getDifficulty());
    q1.setDifficulty(Difficulty.EASY);
    assertEquals(Difficulty.EASY, q1.getDifficulty());

    assertEquals(Difficulty.EASY, q2.getDifficulty());
    q2.setDifficulty(Difficulty.HARD);
    assertEquals(Difficulty.HARD, q2.getDifficulty());
  }

  /**
   * Tests the overridden toString method
   */
  @Test
  public void testToString() {
    String output1 =
        """
      Where is Seattle located?
      Answer: Washington State
      Difficulty: Hard
       """;
    String output2 =
        """
      Where is Kirkland?
      Answer: Eastside of Seattle
      Difficulty: Easy
       """;
    assertEquals(output1, q1.toString());
    assertEquals(output2, q2.toString());
  }

  /**
   * Tests equals function with true returns
   */
  @Test
  public void testEqualsTrue() {
    assertEquals(true, q1.equals(q1));
    assertEquals(true, q2.equals(q2));
  }

  /**
   * Tests equals function with false returns
   */
  @Test
  public void testEqualsFalse() {
    assertEquals(false, q1.equals(q2));
    assertEquals(false, q2.equals(q1));
  }

  /**
   * Tests equals with exception
   */
  @Test
  public void testEqualsException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> q1.equals(new LineProcessor()));
  }


}