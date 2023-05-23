package cs3500.pa01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes a new .md files
 */
public class MdFileWriter {
  //fields
  private String path;
  private String contents;

  /**
   * Constructor : instantiates a MDFilerWriter
   *
   * @param path - String with file path (where to write to)
   * @param contents - String with the contents to be written
   *
   */
  public MdFileWriter(String path, String contents) {
    this.path = path;
    this.contents = contents;
  }

  /**
   * Writes contents to a new file
   *
   * @throws IOException if unable to write to the given file path
   */

  public void writeFile() throws IOException {
    //creates file if it doesn't exist already
    File summarize = new File(path);
    try {
      //open writer and write contents
      FileWriter writer = new FileWriter(summarize);
      writer.write(contents);
      writer.close();
    } catch (IOException e) {
      throw new IOException("Unable to write to file.");
      //e.printStackTrace();
    }
  }

}
