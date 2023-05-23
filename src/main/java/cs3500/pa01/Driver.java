package cs3500.pa01;

import cs3500.pa01.Study.ControllerStudy;
import cs3500.pa01.Study.Question.Question;
import cs3500.pa01.Study.QuestionBank.StudySessionQuestionBank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

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
//    //Checks for correct amount of command line args
//    if (args.length != 3) {
//      throw new IllegalArgumentException("Too many or too little arguments");
//    }
//
//    //grab command line inputs
//    final String  path = args[0];
//    final String flag = args[1];
//    final String outputPath = args[2];
//
//    //check if the arguments are valid
//    checkInputArgs(path, flag);
//
//    //Visit all files in the File System given from the path
//    Path filePath = Paths.get(path);
//    FileSystemVisitor fileVisitor = new FileSystemVisitor();
//    Files.walkFileTree(filePath, fileVisitor);
//
//    // Process the contents in all the markdown files + sort
//    // hold all the summarized content
//    String summarize = "";
//    ArrayList<MarkdownFile> mdFileList = fileVisitor.getMarkdownFileList();
//    sort(mdFileList, flag);
//
//    //get all the contents for a new file into one String
//    for (MarkdownFile x : mdFileList) {
//      summarize = summarize + x.getImportantFileContents();
//    }
//    //have to get rid of the blank line at the top of the string
//    summarize = summarize.substring(1);
//
//    //write to the file
//    MdFileWriter writer = new MdFileWriter(outputPath, summarize);
//    writer.writeFile();

//    StudySessionQuestionBank bank = new StudySessionQuestionBank("/Users/soniasheth/Library/CloudStorage/OneDrive-NortheasternUniversity/Sophmore Year/Summer 1/OOD/pa02-soniasheth/SampleQuestionFile.sr");
//    ArrayList<Question> q = bank.generateSessionQuestions(2);
//    for(int i = 0; i < q.size(); i++) {
//      System.out.print(q.get(i).toString());
//    }
//    //System.out.print(bank.toString());

    ControllerStudy c = new ControllerStudy();
    c.runSession();

  }

  /**
   * Sorts a given ArrayList of MarkdownFiles in the way indicated by the given flag
   *
   * @param files an ArrayList of MarkdownFiles
   * @param flag a String containing the way to sort the arraylist
   * @throws IllegalArgumentException if given flag is not a valid flag
   */
  public static void sort(ArrayList<MarkdownFile> files, String flag) {

    if (flag.toUpperCase().equals(Order.FILENAME.name())) {
      //files sorted alphabetically
      Collections.sort(files, new FilenameComparator());
    } else if (flag.toUpperCase().equals(Order.CREATED.name())) {
      //files created first to files created last (ordering) - files created first at the beginning
      Collections.sort(files, new CreationDateComparator());
    } else if (flag.toUpperCase().equals(Order.MODIFIED.name())) {
      //files modified most recently are at the beginning
      Collections.sort(files, new ModifiedDateComparator());
    } else {
      //if not a valid flag
      throw new IllegalArgumentException("Invalid Flag.");
    }
  }

  /**
   * Checks whether the command line inputs ate valid
   *
   * @param path - String path to a given file ot directory
   * @param flag - String flag that holds the ordering
   * @throws IllegalArgumentException if the path doesn't exist or the flag is invalid
   */
  public static void checkInputArgs(String path, String flag) {
    Path inputPath = Paths.get(path);
    //Path newFilePath = Paths.get(outputPath);

    //check if the input path is a valid path that exists
    if (!inputPath.toFile().exists()) {
      throw new IllegalArgumentException("Input path doesn't exist.");
    }

    //check if the flag is a valid flag
    if (!Order.validOrder(flag)) {
      throw new IllegalArgumentException("Flag is not one of specified flags.");
    }

  }
}

