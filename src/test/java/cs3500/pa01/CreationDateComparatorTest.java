package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa01.createstudyguides.CreationDateComparator;
import cs3500.pa01.createstudyguides.MarkdownFile;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the CreationDateComparator Class
 */
class CreationDateComparatorTest {

  //fields needed
  MarkdownFile f1;
  MarkdownFile f2;
  CreationDateComparator comparator;
  private final String directory = "./src/test/resources/Examples";

  /**
   * Initializes Markdown files for testing the comparator
   */
  @BeforeEach
  public void setup() {
    //created the expected list of markdown files (2 below)
    FileTime knownCreationTime1 = FileTime.from(Instant.parse("2023-05-15T00:36:26Z"));
    FileTime knownLastModifedTime1 = FileTime.from(Instant.parse("2023-05-15T00:37:33.217154271Z"));
    f1 = new MarkdownFile(Path.of(directory + "/Arrays.md"),
        "Arrays.md", knownCreationTime1, knownLastModifedTime1);

    FileTime knownCreationTime2 = FileTime.from(Instant.parse("2023-05-15T00:36:36Z"));
    FileTime knownLastModifedTime2 = FileTime.from(Instant.parse("2023-05-15T00:37:53.045412811Z"));
    f2 = new MarkdownFile(Path.of(directory + "/Vectors.md"),
        "Vectors.md", knownCreationTime2, knownLastModifedTime2);

    comparator = new CreationDateComparator();
  }

  /**
   * Tests comparator with case that first MarkdownFile's creation time comes before the second
   */
  @Test
  public void testCompareComesBefore() {
    assertEquals(-1, comparator.compare(f1, f2));
  }

  /**
   * Tests comparator with case that first MarkdownFile comes after the second
   */
  @Test
  public void testCompareComesAfter() {
    assertEquals(1, comparator.compare(f2, f1));
  }

  /**
   * Tests comparator with case that first MarkdownFile and second Markdownfile creation time are
   * the same
   */
  @Test
  public void testCompareEqual() {
    assertEquals(0, comparator.compare(f1, f1));
  }

}