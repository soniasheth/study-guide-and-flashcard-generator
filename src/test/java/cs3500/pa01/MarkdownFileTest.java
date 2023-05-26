package cs3500.pa01;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa01.createstudyguides.MarkdownFile;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for the MarkdownFile class
 */
class MarkdownFileTest {

  //fields needed
  MarkdownFile f1;
  MarkdownFile f2;
  MarkdownFile f3;
  MarkdownFile f5;
  private final String directory = "./src/test/resources/Examples";

  /**
   * Instantiates MarkdownFiles files for testing
   */
  @BeforeEach
  public void setup() {
    //created the expected list of markdown files (3 below)
    FileTime knownCreationTime1 = FileTime.from(Instant.parse("2023-05-15T00:36:26Z"));
    FileTime knownLastModifedTime1 = FileTime.from(Instant.parse("2023-05-15T00:37:33.217154271Z"));
    f1 = new MarkdownFile(Path.of(directory + "/Arrays.md"),
        "Arrays.md", knownCreationTime1, knownLastModifedTime1);

    FileTime knownCreationTime2 = FileTime.from(Instant.parse("2023-05-15T00:36:36Z"));
    FileTime knownLastModifedTime2 = FileTime.from(Instant.parse("2023-05-15T00:37:53.045412811Z"));
    f2 = new MarkdownFile(Path.of(directory + "/Vectors.md"),
        "Vectors.md", knownCreationTime2, knownLastModifedTime2);

    FileTime knownCreationTime3 = FileTime.from(Instant.parse("2023-05-16T00:45:45Z"));
    FileTime knownLastModifedTime3 = FileTime.from(Instant.parse("2023-05-16T00:45:45.774276125Z"));
    f3 = new MarkdownFile(Path.of(directory + "/Empty.md"),
        "Empty.md", knownCreationTime3, knownLastModifedTime3);


    f5 = new MarkdownFile(Path.of(directory + "/Vectors.md"),
        "Vectors.md", knownCreationTime2, knownLastModifedTime2);
  }

  /**
   * Tests the getName function
   */
  @Test
  public void testGetName() {
    assertEquals("Arrays.md", f1.getName());
    assertEquals("Vectors.md", f2.getName());
    assertEquals("Empty.md", f3.getName());
  }

  /**
   * Tests the getCreationDate function
   */
  @Test
  public void testGetCreationDate() {
    assertEquals("2023-05-15T00:36:26Z", f1.getCreationDate().toString());
    assertEquals("2023-05-15T00:36:36Z", f2.getCreationDate().toString());
    assertEquals("2023-05-16T00:45:45Z", f3.getCreationDate().toString());
  }

  /**
   * Test the getModificationDate function
   */
  @Test
  public void testGetModificationDate() {
    assertEquals("2023-05-15T00:37:33.217154271Z", f1.getLastModifiedDate().toString());
    assertEquals("2023-05-15T00:37:53.045412811Z", f2.getLastModifiedDate().toString());
    assertEquals("2023-05-16T00:45:45.774276125Z", f3.getLastModifiedDate().toString());
  }

  /**
   * Tests the getImportantContents function
   */
  @Test
  public void testGetImportantFileContents() {
    String contentsArray =
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
             """;
    assertEquals(contentsArray, f1.getImportantFileContents());

    String contentsVector =
        """
                        
            # Vectors
            - Vectors act like resizable arrays
                        
            ## Declaring a vector
            - General Form: Vector<type> v = new Vector();
            - type needs to be a valid reference type
                        
            ## Adding an element to a vector
            - v.add(object of type);
            """;
    assertEquals(contentsVector, f2.getImportantFileContents());
  }

  /**
   * Tests empty case of getImportantContents function
   */
  @Test
  public void testEmptyCase() {

    assertEquals("", f3.getImportantFileContents());
  }

  /**
   * Tests exception case with incorrect path of getImportantContents function
   */
  @Test
  public void testExceptionCase() {
    FileTime knownCreationTime3 = FileTime.from(Instant.parse("2023-05-16T00:45:45Z"));
    FileTime knownLastModifedTime3 = FileTime.from(Instant.parse("2023-05-16T00:45:45.774276125Z"));
    // Checking an invalid score produces the correct exception
    assertThrows(
        // .class refers to the type, not an instance of the IllegalArgumentException class
        IllegalArgumentException.class,
        () -> new MarkdownFile(Path.of("nothing"),
            "Empty.md", knownCreationTime3, knownLastModifedTime3));
  }

  /**
   * Tests getFileQuestions method (success)
   */
  @Test
  public void testgetFileQuestions() {
    String contentExpect =
        """
        Are arrays different in C++?
        Answer: A little bit
        Difficulty: Hard
                    
        What is the capital of Canada?
        Answer: The capital is Ottawa.
        Difficulty: Hard
                    
        Which country is known as the Land of the Rising Sun?
        Answer: Japan.
        Difficulty: Hard
                    
        What is the largest river in Africa?
        Answer: The largest river is the Nile River.
        Difficulty: Hard
                    
        What is the tallest mountain in North America?
        Answer: The tallest mountain is Denali (also known as Mount McKinley).
        Difficulty: Hard
                    
        Which continent is the driest inhabited continent on Earth?
        Answer: Australia.
        Difficulty: Hard
                    
        What is the longest river in South America?
        Answer: The longest river is the Amazon River.
        Difficulty: Hard
        
        """;
    assertEquals(contentExpect, f1.getFileQuestions());
  }

  /**
   * Tests Tests getFileQuestions method (empty)
   */
  @Test
  public void testgetFileQuestionsEmpty() {
    assertEquals("", f3.getFileQuestions());
  }

  /**
   * Tests equals function with true returns
   */
  @Test
  public void testEqualsTrue() {
    assertEquals(true, f1.equals(f1));
    assertEquals(true, f2.equals(f2));
    assertEquals(true, f2.equals(f5));

  }

  /**
   * Tests equals function with false returns
   */
  @Test
  public void testEqualsFalse() {
    FileTime knownCreationTime2 = FileTime.from(Instant.parse("2023-04-15T00:36:36Z"));
    FileTime knownLastModifedTime2 = FileTime.from(Instant.parse("2023-04-15T00:37:53.045412811Z"));
    MarkdownFile f6 = new MarkdownFile(Path.of(directory + "/Vectors.md"),
        "Vectos.md", knownCreationTime2, knownLastModifedTime2);
    assertEquals(false, f2.equals(f1));
    assertEquals(false, f2.equals(f3));
  }

  /**
   * Tests equals with exception
   */
  @Test
  public void testEqualsException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> f1.equals(new LineProcessor()));
  }

}