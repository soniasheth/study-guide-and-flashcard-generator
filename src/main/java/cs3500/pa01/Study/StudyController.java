package cs3500.pa01.Study;

import cs3500.pa01.MdFileWriter;
import cs3500.pa01.Study.StudyViewer.StudyViewer;
import cs3500.pa01.Study.Question.Question;
import cs3500.pa01.Study.StudySession.StudySession;
import java.io.IOException;
import java.util.ArrayList;

// where to put the sessionQuestions OBJECT
// stuff to go into the constructor - can i put the study tracker stuff in the constructor?
// abstracting the methods in Session Questions
public class StudyController {
  StudyViewer view;
  //StudySession studyTracker;

  public StudyController() {
    view = new StudyViewer();
  }

  public void runSession() throws IOException {
    view.showWelcome();
    String path = view.getUserResponse("Enter the .sr file link: ");
    String numQ = view.getUserResponse("How many questions do you want answer today: ");

    StudySession studyTracker = new StudySession(Integer.parseInt(numQ), path);
    ArrayList<Question> sessionQuestions = studyTracker.getSessionQuestions();

    boolean exitFlag = false;
    for(Question x : sessionQuestions) {
      view.showElement(x.getQuestion());
      UserOptions response = UserOptions.fromVal(view.showUserOptions());
      switch(response) {
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
      if(exitFlag) {
        break;
      }
    }
    //prints stats to console
    view.showElement(studyTracker.toString());
    //update the file
    updateSrFile(studyTracker.allQuestions(), path);
    //print the end message
    view.printEndMessage();
  }

  public void updateSrFile(String contents, String path) throws IOException {
    MdFileWriter writer = new MdFileWriter(path, contents);
    writer.writeFile();
  }
}
