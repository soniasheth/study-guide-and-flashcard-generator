package cs3500.pa01.Study.Printer;

public class Printer {

  public void printIntroduction() {

  }

  public void printUserOptions() {
    String options =
        """
        1. Mark as Easy
        2. Mark as Hard
        3. Request Answer
        4. Exit
        """;
    System.out.println(options);
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

  public void printEndStats() {

  }

  public void printEndMessage() {
    System.out.println("Congrats! You finished your study session!");

  }
}
