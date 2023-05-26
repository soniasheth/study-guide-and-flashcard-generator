package cs3500.pa01.Study;

import cs3500.pa01.Controller;
import cs3500.pa01.MdFileWriter;
import cs3500.pa01.Study.StudySession.Model;
import cs3500.pa01.Study.Question.Question;
import cs3500.pa01.Study.StudyViewer.View;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Controller for running a Study Session
 */
public class StudyController implements Controller {
  //fields
  View view;
  Model studyTracker;

  /**
   * Instantiates a Study Controller object
   */
  public StudyController(View view, Model model) {
    this.view = view;
    this.studyTracker = model;
  }

  /**
   * Runs the program
   *
   * @throws IOException if file unable to open
   */

  public void run() throws IOException {
    //introduction
    view.showElement("Welcome to your Study Session! Let's get started!");
    String path = view.getUserResponse("Enter the .sr file link: ");
    String numQ = view.getUserResponse("How many questions do you want answer today: ");

    //initalize the questions
    ArrayList<Question> sessionQuestions =
        studyTracker.initializeSessionQuestions(Integer.parseInt(numQ), path);

    //processes user input
    boolean exitFlag = false;
    for (Question x : sessionQuestions) {
      view.showElement(x.getQuestion());
      UserOptions response = UserOptions.fromVal(view.showUserOptions());
      switch (response) {
        case EASY:
          studyTracker.markedQuestion(x, "easy");
          break;
        case HARD:
          studyTracker.markedQuestion(x, "hard");
          break;
        case SHOW_ANSWER:
          view.showElement(x.getAnswer());
          studyTracker.increaseQuestionsAnswered();
          break;
        case EXIT:
          exitFlag = true;
          break;
        default:
          throw new IllegalArgumentException("Invalid Answer.");
      }
      if (exitFlag) {
        break;
      }
    }
    //prints stats to console
    view.showElement(studyTracker.toString());
    //update the file
    updateSrFile(studyTracker.allQuestions(), path);
    //print the end message
    view.showElement("Congrats! You finished your study session!");
  }

  /**
   * Updates the .sr file with the new metadata from the session
   *
   * @param contents new content
   * @param path path to the .sr file
   * @throws IOException if unable to write
   */
  public void updateSrFile(String contents, String path) throws IOException {
    MdFileWriter writer = new MdFileWriter(path, contents);
    writer.writeFile();
  }
}
