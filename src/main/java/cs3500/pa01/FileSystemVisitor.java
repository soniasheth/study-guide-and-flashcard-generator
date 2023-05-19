package cs3500.pa01;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 Walks through an entire file system
 */
public class FileSystemVisitor implements FileVisitor<Path> {
  //fields
  private ArrayList<MarkdownFile> mdFiles;
  private boolean visited;

  /**
   Constructor that instantiates the fields
   */
  FileSystemVisitor() {
    this.mdFiles = new ArrayList<>();
    this.visited = false;
  }

  /**
   * Visits every files and directory in the system and adds only the .md
   * files to the arraylist. Searches for the .md files
   *
   * @param file
   *          a reference to the file - Path
   * @param attr
   *          the file's basic attributes - BasicFileAttributes
   *
   * @return CONTINUE to keep going to other files
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
    if (attr.isRegularFile()) {
      visited = true;
      String name = file.getFileName().toString();
      //adds all the .md files and file attributes to the arraylist
      if (name.endsWith(".md")) {
        mdFiles.add(new MarkdownFile(file, name, attr.creationTime(), attr.lastModifiedTime()));
      }
    }
    return CONTINUE;
  }

  /**
   * Called after visiting a directory
   *
   * @param dir
   *          a reference to the directory
   * @param exec
   *          {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return CONTINUE to keep going to other files
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exec) {
    return CONTINUE;
  }

  /**
   * Called before visiting a directory
   *
   * @param dir
   *          a reference to the directory - Path
   * @param attrs
   *          the directory's basic attributes
   *
   * @return CONTINUE to keep going to other files
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir,
                                           BasicFileAttributes attrs) {
    return CONTINUE;

  }

  /**
   * Handles the case in which the file cannot be visited.
   *
   * @param file
   *          a reference to the file - Path
   * @param exc
   *          the I/O exception that prevented the file from being visited
   *
   * @return CONTINUE to keep going to other files
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    //handles the exeception
    handleException();
    return CONTINUE;
  }

  /**
   * Called by visitFileFailed to handle the exception
   *
   * @throws IllegalArgumentException when a file cannot be visited
   */
  public void handleException() {
    throw new IllegalArgumentException("Visit File Failed");
  }

  /**
   * Gets the ArrayList of ,md files
   *
   * @return the ArrayList of .md files in the file system
   * @throws IllegalStateException when function is called if system hasn't been
   *     visited yet (file walker has not been called)
   */

  public ArrayList<MarkdownFile> getMarkdownFileList() {
    //if file walker has not been called yet
    if (visited == false) {
      throw new IllegalStateException("Files have not been visited yet.");
    } else {
      return this.mdFiles;
    }
  }

}
