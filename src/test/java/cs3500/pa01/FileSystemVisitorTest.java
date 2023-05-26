package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa01.createstudyguides.FileSystemVisitor;
import cs3500.pa01.createstudyguides.MarkdownFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the FileSystemVisitor Class
 */
class FileSystemVisitorTest {
  private final String directory = "./src/test/resources/Examples";
  private FileSystemVisitor fileVisitor;

  /**
   * Initializes visitor for testingr
   */
  @BeforeEach
  public void setUp() {
    fileVisitor = new FileSystemVisitor();
  }

  /**
   * Tests getMarkdownFilesList() function
   *
   * @throws IOException if called
   */
  @Test
  public void testGetMarkdownFileList() throws IOException {
    Files.walkFileTree(Path.of(directory), fileVisitor);

    Path p1 = Path.of(directory + "/Arrays.md");
    BasicFileAttributes attrs = Files.readAttributes(p1, BasicFileAttributes.class);
    MarkdownFile f1 = test(p1, attrs);

    Path p2 = Path.of(directory + "/Vectors.md");
    BasicFileAttributes attrs2 = Files.readAttributes(p2, BasicFileAttributes.class);
    MarkdownFile f2 = test(p2, attrs2);

    Path p3 = Path.of(directory + "/Empty.md");
    BasicFileAttributes attrs3 = Files.readAttributes(p3, BasicFileAttributes.class);
    MarkdownFile f3 = test(p3, attrs3);

    ArrayList<MarkdownFile> mdFilesExpected = new ArrayList<>();
    mdFilesExpected.add(f1);
    mdFilesExpected.add(f2);
    mdFilesExpected.add(f3);

    //get actual list of markdown files
    ArrayList<MarkdownFile> mdFilesActual = fileVisitor.getMarkdownFileList();

    //compare each Markdown File in expected + actual
    assertEquals(3, mdFilesActual.size());
    for (int i = 0; i < mdFilesActual.size(); i++) {
      assertEquals(mdFilesActual.get(i), mdFilesExpected.get(i));
    }
  }

  /**
   * Tests testHandleException method
   */
  @Test
  public void testHandleException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> fileVisitor.handleException());
  }

  @Test
  public void testHandleVisitFileFailed() {
    assertThrows(
        IllegalArgumentException.class,
        () -> fileVisitor.visitFileFailed(Path.of(directory + "/Empty.md"),
            new IOException("hello")));

  }

  /**
   * Test getMarkdownFile exception
   */
  @Test
  public void testgetMarkdownFileException() {
    FileSystemVisitor fileVisitor = new FileSystemVisitor();
    assertThrows(
        IllegalStateException.class,
        () -> fileVisitor.getMarkdownFileList());
  }

  /**
   * Makes a MarkdownFile for testing purposes
   *
   * @param p path
   * @param attribs has file attribs
   * @return MarkdownFile
   */
  public MarkdownFile test(Path p, BasicFileAttributes attribs) {
    FileTime createdAt = attribs.creationTime();
    FileTime modifiedAt = attribs.lastModifiedTime();
    MarkdownFile mdf = new MarkdownFile(p, p.getFileName().toString(), createdAt, modifiedAt);
    return mdf;
  }



}