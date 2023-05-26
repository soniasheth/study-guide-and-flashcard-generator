package cs3500.pa01;

import cs3500.pa01.createstudyguides.StudyGuidesController;
import cs3500.pa01.study.StudyController;
import cs3500.pa01.study.studysession.Model;
import cs3500.pa01.study.studysession.StudySession;
import cs3500.pa01.study.studyviewer.StudyViewer;
import cs3500.pa01.study.studyviewer.View;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * This is the main driver of this project.
 */

public class Driver {
  /**
   * Project entry point: Serves as the 'home base' to instantiate objects
   *
   * @param args - no command line args required, however 3 needed: path, flag, and output path
   * @throws IOException - when running the run method in controller
   */
  public static void main(String[] args) throws IOException {
    //runs creating a Study guide + Question Bank
    if (args.length == 3) {
      String  path = args[0];
      String flag = args[1];
      String outputPath = args[2];
      StudyGuidesController controller = new StudyGuidesController(path, flag, outputPath);
      controller.run();
    } else if (args.length == 0) {
      //runs a Study Session
      View view = new StudyViewer(new PrintStream(System.out), new InputStreamReader(System.in));
      Model model = new StudySession();
      StudyController controller = new StudyController(view, model);
      controller.run();
    } else {
      throw new IllegalArgumentException("Too little or too many arguments");
    }

  }
}

