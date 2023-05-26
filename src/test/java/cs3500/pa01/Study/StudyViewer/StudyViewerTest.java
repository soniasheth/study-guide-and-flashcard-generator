package cs3500.pa01.Study.StudyViewer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the StudyViewer Class
 */
class StudyViewerTest {
  //fields
  StudyViewer viewer;

  /**
   * Set up
   */
  @BeforeEach
  public void setUp() {
    String test =
        """
            hello
            my 
            name
            is 
            sonia
            """;
    viewer = new StudyViewer(new StringBuilder(), new StringReader(test));
  }

  /**
   * Tests the getElement function in the viewer
   * @throws IOException if appendable cannot append
   */
  @Test
  public void testGetElement() throws IOException {
    //empty to begin with
    assertEquals("", viewer.appendable.toString());

    viewer.showElement("hello");
    assertEquals("hello\n", viewer.appendable.toString());
  }

  /**
   * Tests the showUserOptions function in the viewer
   * @throws IOException if appendable cannot append
   */
  @Test
  public void testShowUserOptions() throws IOException {
    //empty to begin with
    assertEquals(viewer.appendable.toString(), "");

    String options =
        """
        1. Mark as Easy | 2. Mark as Hard | 3. Request Answer | 4. Exit
        Choose your response:
        """;

    viewer.showUserOptions();
    assertEquals(options , viewer.appendable.toString());
  }

}