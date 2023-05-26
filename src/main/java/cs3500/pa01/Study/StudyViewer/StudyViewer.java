package cs3500.pa01.Study.StudyViewer;

import java.io.IOException;
import java.util.Scanner;

public class StudyViewer implements View {
  Scanner userInput;
  Appendable appendable;
  Readable readable;

  public StudyViewer(Appendable appendable, Readable readable) {
    userInput = new Scanner(readable);
    this.appendable = appendable;
    this.readable = readable;
  }

//  public void showWelcome() throws IOException {
//    appendable.append("Welcome to your Study Session! Let's get started!");
//    appendable.append("\n");
//  }

  public String getUserResponse(String prompt) throws IOException {
    appendable.append(prompt);
    String response = userInput.nextLine();
    appendable.append("\n");
    return response;
  }

  public String showUserOptions() throws IOException {
    String options =
        """
        1. Mark as Easy | 2. Mark as Hard | 3. Request Answer | 4. Exit
        Choose your response:""";
    return getUserResponse(options);
  }

  public void showElement(String element) throws IOException {
    appendable.append(element);
    appendable.append("\n");

  }
//  public void printEndMessage() throws IOException {
//    appendable.append("Congrats! You finished your study session!");
//  }
}
