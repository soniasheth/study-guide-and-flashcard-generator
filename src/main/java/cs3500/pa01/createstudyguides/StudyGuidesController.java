package cs3500.pa01.createstudyguides;

import cs3500.pa01.Controller;
import cs3500.pa01.MdFileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Controller for Creating the Study Guides
 */
public class StudyGuidesController implements Controller {
  //fields
  private String path;
  private String flag;
  private String outputPath;

  /**
   * Instantiates a StudyGuide Controller Object
   *
   * @param path path to the file
   * @param flag sorting order
   * @param outputPath where to write the .md / .sr files to
   */
  public StudyGuidesController(String path, String flag, String outputPath) {
    this.path = path;
    this.flag = flag;
    this.outputPath = outputPath;
  }

  /**
   * Runs the program
   *
   * @throws IOException if file is unable to opened
   */
  public void run() throws IOException {
    //check if the arguments are valid
    checkInputArgs(path, flag);

    //Visit all files in the File System given from the path
    Path filePath = Paths.get(path);
    FileSystemVisitor fileVisitor = new FileSystemVisitor();
    Files.walkFileTree(filePath, fileVisitor);

    // Process the contents in all the markdown files + sort
    // hold all the summarized content
    String summarize = "";
    String questions = "";
    ArrayList<MarkdownFile> mdFileList = fileVisitor.getMarkdownFileList();
    sort(mdFileList, flag);

    //get all the contents for a new file into one String
    for (MarkdownFile x : mdFileList) {
      summarize = summarize + x.getImportantFileContents();
      questions = questions + x.getFileQuestions();
    }

    //have to get rid of the blank line at the top of the string
    summarize = summarize.substring(1);
    //questions = questions.substring(1);

    //create a output path for the question file
    int indexFileName = outputPath.lastIndexOf('.');
    String questionOutputPath = outputPath.substring(0, indexFileName) + ".sr";

    //write to the .md and .sr files
    MdFileWriter writeStudyGuide = new MdFileWriter(outputPath, summarize);
    MdFileWriter writeQuestionBank = new MdFileWriter(questionOutputPath, questions);
    writeStudyGuide.writeFile();
    writeQuestionBank.writeFile();
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
