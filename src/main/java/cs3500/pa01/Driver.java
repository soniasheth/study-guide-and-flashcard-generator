package cs3500.pa01;

import cs3500.pa01.CreateStudyGuides.StudyGuidesController;
import cs3500.pa01.Study.StudyController;
import java.io.IOException;

/**
 * This is the main driver of this project.
 */

public class Driver {
  /**
   * Project entry point: Serves as the 'home base' to instantiate objects
   *
   * @param args - no command line args required, however 3 needed: path, flag, and output path
   */
  public static void main(String[] args) throws IOException {
    //runs creating a Study guide + Question Bank
    if(args.length == 3) {
      String  path = args[0];
      String flag = args[1];
      String outputPath = args[2];
      StudyGuidesController controller = new StudyGuidesController(path, flag, outputPath);
      controller.run();
    }
    //runs a Study Session
    else if(args.length == 0) {
      StudyController controller = new StudyController();
      controller.runSession();
    }
    else {
      throw new IllegalArgumentException("Too little or too many arguments");
    }

  }
}

