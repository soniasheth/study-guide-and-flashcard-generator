package cs3500.pa01.Study.StudyViewer;

import java.io.IOException;
import java.util.Scanner;

/**
 * Displays all content to the user
 */
public class StudyViewer implements View {
  //fields
  Scanner userInput;
  Appendable appendable;
  Readable readable;

  /**
   * Instantiates a StudyViewer object
   * @param appendable appendable
   * @param readable readable
   */
  public StudyViewer(Appendable appendable, Readable readable) {
    userInput = new Scanner(readable);
    this.appendable = appendable;
    this.readable = readable;
  }

//  public void showWelcome() throws IOException {
//    appendable.append("Welcome to your Study Session! Let's get started!");
//    appendable.append("\n");
//  }

  /**
   * Displays a prompt to a user and gets their response
   *
   * @param prompt what to display to the user
   * @return the prompt
   * @throws IOException if issues with the appendable
   */
  public String getUserResponse(String prompt) throws IOException {
    appendable.append(prompt);
    String response = userInput.nextLine();
    appendable.append("\n");
    return response;
  }

  /**
   * Displays the options of how to mark a question to the user
   *
   * @return their response
   * @throws IOException if issues with the appenable
   */
  public String showUserOptions() throws IOException {
    String options =
        """
        1. Mark as Easy | 2. Mark as Hard | 3. Request Answer | 4. Exit
        Choose your response:""";
    return getUserResponse(options);
  }

  /**
   * Takes in a String and displays to user
   *
   * @param element String to display
   * @throws IOException if issues with appendable
   */
  public void showElement(String element) throws IOException {
    appendable.append(element);
    appendable.append("\n");

  }
//  public void printEndMessage() throws IOException {
//    appendable.append("Congrats! You finished your study session!");
//  }
}
