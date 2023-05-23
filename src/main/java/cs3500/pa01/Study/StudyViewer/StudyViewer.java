package cs3500.pa01.Study.StudyViewer;

import java.util.Scanner;

public class StudyViewer {
  Scanner userInput;

  public StudyViewer() {
    userInput = new Scanner(System.in);
  }

  public void showWelcome() {
    System.out.println("Welcome to your Study Session! Let's get started!");
    System.out.println();
  }

  public String getUserResponse(String prompt) {
    System.out.print(prompt);
    String response = userInput.nextLine();
    System.out.println();
    return response;
  }

  public String showUserOptions() {
    String options =
        """
        1. Mark as Easy | 2. Mark as Hard | 3. Request Answer | 4. Exit
        Choose your response:""";
    return getUserResponse(options);
  }

  public void showElement(String element) {
    System.out.println(element);
    System.out.println();

  }
  public void printEndMessage() {
    System.out.println("Congrats! You finished your study session!");
  }
}
