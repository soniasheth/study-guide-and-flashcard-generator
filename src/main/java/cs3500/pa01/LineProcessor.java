package cs3500.pa01;

/**
 * Represents an editor that the processes and edits Strings
 */
public class LineProcessor {
  /**
   * Processes a given String from a .md file
   * to grab important content: the content between double brackets [[ ]] and/or
   * headers
   *
   * @param content - String to be processed and edited
   * @return the newly edited string without double brackets [[ ]]
   */
  public String processFileLine(String content) {
    StringBuilder newContent = new StringBuilder();
    //if string is a header
    if (!content.isEmpty() && content.charAt(0) == '#') {
      return "\n" + content + "\n";
    } else {
      while (content.contains("[[") || content.contains("]]")) {

        if (content.contains("[[") && content.contains("]]")) {
          //entire important content on the line, grab it all
          int begin = content.indexOf("[[");
          int end = content.indexOf("]]");
          newContent.append("- " + content.substring(begin + 2, end) + "\n");
          content = content.substring(end + 1);
        } else if (content.contains("[[")) {
          //important content goes onto the next line, grab what is on this line
          int begin = content.indexOf("[[");
          //do not add new line since more content on next line
          newContent.append("- " + content.substring(begin + 2));
          content = content.substring(begin + 2);
        } else if (content.contains("]]")) {
          //important content closes on this line
          int end = content.indexOf("]]");
          newContent.append(content.substring(0, end) + "\n");
          content = content.substring(end + 1);
        }
      }
      return newContent.toString();
    }
  }
}
