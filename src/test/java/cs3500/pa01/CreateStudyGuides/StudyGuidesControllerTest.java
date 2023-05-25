package cs3500.pa01.CreateStudyGuides;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa01.Driver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyGuidesControllerTest {
  //fields needed
  private final String directory = "./src/test/resources/Examples";
  ArrayList<MarkdownFile> files;
  MarkdownFile f1;
  MarkdownFile f2;
  MarkdownFile f3;

  StudyGuidesController controller;

  /**
   * Initializes visitor and the Driver testing the Driver
   */
  @BeforeEach
  public void setUp() throws IOException {
    FileSystemVisitor v1 = new FileSystemVisitor();
    Files.walkFileTree(Path.of(directory), v1);
    files = v1.getMarkdownFileList();
    controller = new StudyGuidesController("", "filename", "3");
  }


  /**
   * Initializes Markdown files for testing the comparator
   */
  @BeforeEach
  public void createFiles() throws IOException {
    Path p1 = Path.of(directory + "/Arrays.md");
    Files.setLastModifiedTime(p1, FileTime.from(Instant.parse("2023-05-15T00:37:33.217154271Z")));
    BasicFileAttributes attrs = Files.readAttributes(p1, BasicFileAttributes.class);
    f1 = test(p1, attrs);


    Path p2 = Path.of(directory + "/Vectors.md");
    Files.setLastModifiedTime(p2, FileTime.from(Instant.parse("2023-05-15T00:37:53.045412811Z")));
    BasicFileAttributes attrs2 = Files.readAttributes(p2, BasicFileAttributes.class);
    f2 = test(p2, attrs2);

    Path p3 = Path.of(directory + "/Empty.md");
    Files.setLastModifiedTime(p3, FileTime.from(Instant.parse("2023-05-16T00:45:45.774276125Z")));
    BasicFileAttributes attrs3 = Files.readAttributes(p3, BasicFileAttributes.class);
    f3 = test(p3, attrs3);
  }

  /**
   * Testing the sorting method in driver by filename
   */
  @Test
  public void testSortbyFilenameSuccees() {
    ArrayList<MarkdownFile> sortedByFilenameKnown = new ArrayList<>();
    sortedByFilenameKnown.add(f1);
    sortedByFilenameKnown.add(f3);
    sortedByFilenameKnown.add(f2);
    controller.sort(files, "filename");

    for (int i = 0; i < files.size(); i++) {
      assertEquals(sortedByFilenameKnown.get(i), files.get(i));
    }

  }

  /**
   * Testing sorting method in driver by creation time
   */
  @Test
  public void testSortbyCreationSuccees() {
    ArrayList<MarkdownFile> sortedByCreation = new ArrayList<>();
    sortedByCreation.add(f1);
    sortedByCreation.add(f2);
    sortedByCreation.add(f3);
    controller.sort(files, "created");

    assertEquals(3, files.size());
    assertEquals(3, sortedByCreation.size());

    for (int i = 0; i < files.size(); i++) {
      assertEquals(sortedByCreation.get(i), files.get(i));
    }

  }

  /**
   * Testing sorting method in driver by Modified time
   */
  @Test
  public void testSortbyModifiedSuccees() {
    ArrayList<MarkdownFile> sortedByModified = new ArrayList<>();
    sortedByModified.add(f3);
    sortedByModified.add(f2);
    sortedByModified.add(f1);
    controller.sort(files, "modified");

    assertEquals(3, files.size());
    assertEquals(3, sortedByModified.size());

    for (int i = 0; i < files.size(); i++) {
      assertEquals(sortedByModified.get(i), files.get(i));
    }

  }

  /**
   * Testing sort method in driver, exception case
   */
  @Test
  public void testSortFail() {
    // Checking an invalid flag produces the correct exception
    assertThrows(
        IllegalArgumentException.class,
        () -> controller.sort(files, "bad flag"));
  }

  /**
   Tests checkInputArgs function in driver with a valid Path and flag
   */
  @Test
  public void testCheckInputArgsValid()  {
    assertDoesNotThrow(() ->
        controller.checkInputArgs(directory, "filename"));
    assertDoesNotThrow(() ->
        controller.checkInputArgs(directory, "modified"));
    assertDoesNotThrow(() ->
        controller.checkInputArgs(directory, "created"));
  }

  /**
   Tests checkInputArgs function in driver with an invalid path
   Tests exception
   */
  @Test
  public void testInputArgsInvalidPath() {
    assertThrows(
        IllegalArgumentException.class,
        () -> controller.checkInputArgs("bad path", "filename"));

  }

  /**
   Tests checkInputArgs function in driver with an invalid flag
   Tests exception case
   */

  @Test
  public void testInputArgsInvalidFlag() {
    assertThrows(
        IllegalArgumentException.class,
        () -> controller.checkInputArgs(directory, "sonia"));

  }

  /**
   * Tests main method in driver
   *
   * @throws IOException if there are incorrect amount of input args
   *
   */
  @Test
  public void testRun() throws IOException {
    String[] args = new String[] {"./src/test/resources/Examples",
        "filename", "./src/test/resources/Examples/Testing.md"};
    assertDoesNotThrow(() ->
        controller.run());

    //check if file contents are the same
    String contentActual = "";
    String contentExpect =
        """
        # Java Arrays
        - An **array** is a collection of variables of the same type

        ## Declaring an Array
        - General Form: type[] arrayName;
        - only creates a reference
        - no array has  actually been created yet

        ## Creating an Array (Instantiation)
        - General form:  arrayName = new type[numberOfElements];
        - numberOfElements must be a positive Integer.
        - Gotcha: Array size is not  modifiable once instantiated.

        # Vectors
        - Vectors act like resizable arrays

        ## Declaring a vector
        - General Form: Vector<type> v = new Vector();
        - type needs to be a valid reference type

        ## Adding an element to a vector
        - v.add(object of type);
        """;

    File tempFile = new File("./src/test/resources/Examples/Testing.md");
    Scanner fileScan = new Scanner(tempFile);
    while (fileScan.hasNextLine()) {
      contentActual = contentActual + fileScan.nextLine() + "\n";
    }
    assertEquals(contentExpect, contentActual);

    tempFile.delete();
  }

  /**
   * Tests main method in driver with an exception
   */
  @Test
  public void testMainFail() {
    String[] args = new String[] {"./src/test/resources/Examples",
        "./src/test/resources/Examples/Testing.md"};
    assertThrows(
        IllegalArgumentException.class,
        () -> controller.run());
  }





  /**
   * Makes a MarkdownFile for testing purposes
   *
   * @param p path
   * @param attribs file attribs
   * @return MarkdownFile
   */
  //makes a markdown file and gets the attributes
  public MarkdownFile test(Path p, BasicFileAttributes attribs) {
    FileTime createdAt = attribs.creationTime();
    FileTime modifiedAt = attribs.lastModifiedTime();
    MarkdownFile mdf = new MarkdownFile(p, p.getFileName().toString(), createdAt, modifiedAt);
    return mdf;
  }


}