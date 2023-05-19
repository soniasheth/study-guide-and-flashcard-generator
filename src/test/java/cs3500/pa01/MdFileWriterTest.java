package cs3500.pa01;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MdFileWriterTest {
  //fields
  private String pathCorrect = "./src/test/resources/Examples/WriterTest";
  private String pathIncorrect = "./src/test/resources/Example/WriterTest";
  private String contents = "This is to test the writer class.";
  //one writer with a correct path and one writer with an incorrect path
  private MdFileWriter writer1;
  private MdFileWriter writer2;

  /**
   * Instantiates MDFileWriter objects needed for testing
   * One for a correct path and one for incorrect path
   */
  @BeforeEach
  public void setup() {
    //sets up both writers
    writer1 = new MdFileWriter(pathCorrect, contents);
    writer2 = new MdFileWriter(pathIncorrect, contents);
  }

  /**
   * Test writeFile method (successfully writes a file)
   */
  @Test
  public void testWriteFileSuccess() {
    //makes sure that the file is created without any error
    assertDoesNotThrow(() -> writer1.writeFile());

    //delete the new file that was created for the testing
    File tempFile = new File(pathCorrect);
    tempFile.delete();

  }

  /**
   * //Tests writeFile method (fails to write a file)
   * Exception
   */
  @Test
  public void testWriteFileFailure() {
    assertThrows(
        IOException.class,
        () -> writer2.writeFile());
  }

}