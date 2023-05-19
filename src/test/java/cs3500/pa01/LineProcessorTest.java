package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;

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






}