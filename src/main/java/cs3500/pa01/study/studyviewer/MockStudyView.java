package cs3500.pa01.study.studyviewer;

import java.io.IOException;

/**
 * Mock class for Study View (for testing)
 */
public class MockStudyView implements View {

  Appendable ap;
  private String choice;

  public MockStudyView() {
    this.ap = new StringBuilder();
  }

  /**
   * Instantiates object
   *
   * @param choice question choice
   */
  public MockStudyView(String choice) {
    this.ap = new StringBuilder();
    this.choice = choice;
  }

  /**
   * Displays a prompt to a user and gets their response
   *
   * @param prompt what to display to the user
   * @return the prompt
   * @throws IOException if issues with the appendable
   */
  @Override
  public String getUserResponse(String prompt) throws IOException {
    ap.append("userresponse ");
    return "1";
  }

  /**
   * Displays the options of how to mark a question to the user
   *
   * @return their response
   * @throws IOException if issues with the appenable
   */
  @Override
  public String showUserOptions() throws IOException {
    ap.append("showUserOptions ");
    return choice;
  }

  /**
   * Takes in a String and displays to user
   *
   * @param element String to display
   * @throws IOException if issues with appendable
   */
  @Override
  public void showElement(String element) throws IOException {
    ap.append("showelement ");
  }

  /**
   * Returns the appendable
   *
   * @return the appendable
   */
  public String getAppendable() {
    return ap.toString();
  }


}
