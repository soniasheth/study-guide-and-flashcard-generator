package cs3500.pa01.Study.StudyViewer;

import java.io.IOException;
import java.util.Scanner;

/**
 * Interface that represents the View
 */
public interface View {

  /**
   * Displays a prompt to a user and gets their response
   *
   * @param prompt what to display to the user
   * @return the prompt
   * @throws IOException if issues with the appendable
   */
  String getUserResponse(String prompt) throws IOException;

  /**
   * Displays the options of how to mark a question to the user
   *
   * @return their response
   * @throws IOException if issues with the appenable
   */
  String showUserOptions() throws IOException;

  /**
   * Takes in a String and displays to user
   *
   * @param element String to display
   * @throws IOException if issues with appendable
   */
  void showElement(String element) throws IOException;
}
