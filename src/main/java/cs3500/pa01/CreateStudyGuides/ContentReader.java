package cs3500.pa01.CreateStudyGuides;

import cs3500.pa01.LineProcessor;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Reads a given file and separates content into desired Strings
 */
public class ContentReader {
  //fields
  private LineProcessor processor;
  private Path path;
  private StringBuilder content;
  private StringBuilder questions;

  /**
   * Instantiates a ContentReader object
   *
   * @param path - path to the file
   */
  ContentReader(Path path) {
    this.path = path;
    processor = new LineProcessor();
    content = new StringBuilder();
    questions = new StringBuilder();
  }

  /**
   * Separates the important file contents into questions and then other content and
   *     and adds to the appropriate String Builder
   */
  public void filterContents() {
    //gets all content read in from the file
    String contents = scanAllImportantContentFromFile();
    Scanner contentScanner = new Scanner(contents);
    while(contentScanner.hasNextLine()) {
      String line = contentScanner.nextLine();
      if(line.contains(":::")) {
        //if a question
        questions.append(processor.processQuestion(line) + "\n");
      } else {
        //if regular content
        content.append(line + "\n");
      }
    }
    contentScanner.close();
  }

  public String getQuestionContent() {
    return this.questions.toString();
  }

  public String getStudyContent() {
    return this.content.toString();
  }

  /**
   * Scans the given class's path Markdown File and grabs the important contents from it
   *     including all questions
   *
   * @return a string with the new important contents, including questions
   */
  private String scanAllImportantContentFromFile() {
    StringBuilder contents = new StringBuilder();
    Scanner fileScanner = null;
    try {
      fileScanner = new Scanner(path);
    } catch (IOException e) {
      throw new IllegalArgumentException("Path is invalid.");
    }
    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine();
      String newContent = processor.processFileLine(line);
      if (newContent != "") {
        contents.append(newContent);
      }
    }

    fileScanner.close();
    return contents.toString();

  }


}
