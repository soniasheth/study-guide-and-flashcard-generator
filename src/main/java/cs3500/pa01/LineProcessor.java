package cs3500.pa01;

import java.io.IOException;

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

  /**
   * Takes in a phrase and a word to remove from the phrase and removes the word
   *     from the phrase if at the beginning of the phrase
   * @param phrase String phrase
   * @param remove String to remove
   * @return a string with the word removed
   * @throws Exception if word to remove is not present in the phrase
   */
  public String removeWord(String phrase, String remove) {
    int index = phrase.indexOf(remove);
    int length = remove.length();
    if(index != -1) {
      return phrase.substring(index + length + 1);
    }
    else {
      throw new IllegalArgumentException("String to remove not present in the phrase");
    }
  }

  /**
   * Processes a String line with a question and answer:
   *     extracts both the question and answer and formats it
   *     for a file
   *
   * @param questionLine String with the question and answer separated by :::
   * @return a String with the question, answer, and difficulty properly formatted
   */
  public String processQuestion(String questionLine) {
    StringBuilder formattedQuestion = new StringBuilder();
    int index = questionLine.indexOf(":::");
    String question = questionLine.substring(2, index);
    String answer = questionLine.substring(index + 3);
    //get rid of the extra space at the end of the question
    if(question.charAt(question.length() - 1) == ' ') {
      question = question.substring(0,question.length() - 1);
    }
    if(answer.charAt(0) == ' ') {
      answer = answer.substring(1);
    }
    formattedQuestion.append(question + "\n");
    formattedQuestion.append("Answer: " + answer + "\n");
    formattedQuestion.append("Difficulty: Hard" + "\n");
    return formattedQuestion.toString();
  }
}
