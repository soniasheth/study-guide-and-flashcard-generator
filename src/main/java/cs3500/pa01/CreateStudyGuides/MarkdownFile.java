package cs3500.pa01.CreateStudyGuides;

import cs3500.pa01.LineProcessor;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

/**
 * Represents a Markdown File and its attributes
 */
public class MarkdownFile {

  //fields
  private Path path;
  private String name;
  private FileTime creationDate;
  private FileTime lastModifiedDate;
  private ContentReader reader;

  /**
   * Constructor: Instantiates a Markdown File
   *
   * @param path the file path
   * @param name the file name
   * @param creationDate the file creation time
   * @param lastModifiedDate the file lastModified time
   */
  public MarkdownFile(Path path, String name, FileTime creationDate, FileTime lastModifiedDate) {
    this.path = path;
    this.name = name;
    this.creationDate = creationDate;
    this.lastModifiedDate = lastModifiedDate;
    this.reader = new ContentReader(path);
    // immediately processes the contents in the file
    // reader.filterContents();
  }

  /**
   * Gets the name field of this MarkdownFile
   *
   * @return the name of this MarkdownFile
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the creation time field of this MarkdownFile
   *
   * @return the creation time of this MarkdownFile
   */
  public FileTime getCreationDate() {
    return this.creationDate;
  }

  /**
   * Gets the last modified time field of this MarkdownFile
   *
   * @return the last modified time of this MarkdownFile
   */
  public FileTime getLastModifiedDate() {
    return this.lastModifiedDate;
  }

  /*public String getAllFileContents() throws IOException {
    return Files.readString(path);
  }*/

  /**
   * Scans this Markdown File and grabs the important contents from it
   *
   * @return a string with the new important contents
   */
  public String getImportantFileContents() {
    StringBuilder contents = new StringBuilder();
    Scanner fileScanner = null;
    LineProcessor processor = new LineProcessor();
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
    //return reader.getStudyContent();
  }


  public String getFileQuestions() {
    return reader.getQuestionContent();
  }

  /**
   * Overrides the equals method: Compares this Markdown file to another object
   * for equality
   *
   * @param other - an object to compare this Markdown file to
   * @return boolean whether this Markdown File is equal to the given one
   */

  public boolean equals(Object other) {
    if (!(other instanceof MarkdownFile)) {
      throw new IllegalArgumentException("Not a MarkdownFile");
    }
    MarkdownFile that = (MarkdownFile) other;
    return this.path.equals(that.path)
        && this.name.equals(that.name)
        && this.creationDate.equals(that.creationDate)
        && this.lastModifiedDate.equals(that.lastModifiedDate);
  }

}
