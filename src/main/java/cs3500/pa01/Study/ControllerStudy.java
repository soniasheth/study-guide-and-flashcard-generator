package cs3500.pa01.Study;

import cs3500.pa01.Study.Printer.Printer;
import cs3500.pa01.Study.QuestionBank.StudySessionQuestionBank;
import cs3500.pa01.Study.StudySession.StudySession;
import java.util.Scanner;

public class ControllerStudy {
  Printer p1;
  Scanner userInput;
  ControllerStudy() {
    p1 = new Printer();
    userInput = new Scanner(System.in);
  }
  public void run() {
    p1.printIntroduction();
    p1.printMessage("Enter Path link: ");
    String path = userInput.nextLine();

    p1.printMessage("How many questions would you like to answer today: ");
    int numQuestions = userInput.nextInt();

    StudySession studyTracker = new StudySession(numQuestions, path);

    String userChoice = "";
    while(userChoice != "4" && studyTracker.done() == false) {
      p1.printMessage(studyTracker.getCurrentQuestion());
      p1.printUserOptions();
      userChoice = userInput.next();
      studyTracker.processUserChoice(userChoice);
      if(userInput.equals("3")) {
        p1.printMessage("Answer: " + studyTracker.getCurrentAnswer());
      }
    }
    p1.printMessage(studyTracker.toString());
    //studyTracker.updateSrFile();

  }

}
