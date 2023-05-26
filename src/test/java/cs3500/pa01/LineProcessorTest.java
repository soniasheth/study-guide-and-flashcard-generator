package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the LineProcessor Class
 */
class LineProcessorTest {
  //fields
  LineProcessor lp;

  /**
   * Instantiates LineProcessor Object for testing
   */
  @BeforeEach
  public void setup() {
    lp = new LineProcessor();
  }

  /**
   * Tests processFileLine function where string input contains both [[ and ]]
   */
  @Test
  public void testsBothOpenAndClosed() {
    assertEquals("- I need this done\n", lp.processFileLine("[[I need this done]]"));
    assertEquals("- capital\n- Olympia\n- south of Seattle\n",
            lp.processFileLine("The [[capital]] of Washington is [[Olympia]]"
                + " and is [[south of Seattle]]."));
  }

  /**
   * Tests processFileLine function where string input contains only [[
   */
  @Test
  public void testsOpen() {
    assertEquals("- the class Logic",
        lp.processFileLine("I am so lost in [[the class Logic"));
    assertEquals("- ", lp.processFileLine("hello[["));
  }

  /**
   * Tests processFileLine function where string input contains only ]]
   */
  @Test
  public void testsClosed() {
    assertEquals(" because I fall asleep in class.\n",
        lp.processFileLine(" because I fall asleep in class.]]"));
    assertEquals("the process\n", lp.processFileLine("the process]] is so slow."));
  }

  /**
   * Tests processFileLine function where string input contains a header
   */
  @Test
  public void testsHeader() {
    assertEquals("\n#Washington Facts\n",
        lp.processFileLine("#Washington Facts"));
    assertEquals("\n###Washington Facts\n",
        lp.processFileLine("###Washington Facts"));
  }

  /**
   * Tests processFileLine function where string input is an empty
   */
  @Test
  public void testEmpty() {
    assertEquals("", lp.processFileLine(""));
  }

  /**
   * Tests processFileLine function where string input has no brackets
   */
  @Test
  public void testNoBrackets() {
    assertEquals("", lp.processFileLine("this should be nothing"));
  }

  /**
   * Tests removeWord function successfully working
   */
  @Test
  public void testRemoveWordSucess() {
    String test1 = "Hello my name is Sonia";
    String test2 = "OOD is fun!";
    String test3 = "Difficulty: Hard";
    assertEquals("my name is Sonia", lp.removeWord(test1, "Hello"));
    assertEquals("is fun!", lp.removeWord(test2, "OOD"));
    assertEquals("Hard", lp.removeWord(test3, "Difficulty:"));
  }

  /**
   * Tests removeWord function throwing an exception
   */
  @Test
  public void testRemoveWordFail() {
    String test1 = "Hello my name is Sonia";
    assertThrows(
        IllegalArgumentException.class,
        () -> lp.removeWord(test1, "grass"));
  }

  /**
   * Tests processQuestion function sucessfully working
   */
  @Test
  public void testProcessQuestionSuccess() {
    String question1 = "- Which continent is the driest inhabited continent on Earth?:::Australia.";
    String question2 =
        "- What is the longest river in South America?::: The longest river is the Amazon River.";
    String formatted1 =
        """
            Which continent is the driest inhabited continent on Earth?
            Answer: Australia.
            Difficulty: Hard
            """;
    String formatted2 =
        """
            What is the longest river in South America?
            Answer: The longest river is the Amazon River.
            Difficulty: Hard
            """;
    assertEquals(formatted1, lp.processQuestion(question1));
    assertEquals(formatted2, lp.processQuestion(question2));
  }

  /**
   * Tests processQuestion function throwing an exception
   */
  @Test
  public void testProcessQuestionFail() {
    String question1 = "- Which continent is the driest inhabited continent on Earth?";
    assertThrows(
        IllegalArgumentException.class,
        () -> lp.processQuestion(question1));
  }






}