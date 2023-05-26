package cs3500.pa01.createstudyguides;

import java.util.Comparator;

/**
 Represents a comparator that compares two MarkdownFiles by their filenames
 */
public class FilenameComparator implements Comparator<MarkdownFile> {
  /**
   *Compares two Markdown Files by their filenames
   *
   * @param f1 the first object to be compared - a Markdown File
   * @param f2 the second object to be compared - a Markdown File
   * @return an int representing whether first object's filename
   *     comes before or after the second's
   */
  public int compare(MarkdownFile f1, MarkdownFile f2) {

    return f1.getName().compareTo(f2.getName());
  }
}
