package cs3500.pa01;

import java.util.Comparator;

/**
  Represents a comparator that compares two MarkdownFiles by their creation time
 */
public class CreationDateComparator implements Comparator<MarkdownFile> {

  /**
   *Compares two Markdown Files by their creation time
   *
   * @param f1 the first object to be compared - a Markdown File
   * @param f2 the second object to be compared - a Markdown File
   * @return an int representing whether first object's creation date
   *         comes before or after the second
   */
  public int compare(MarkdownFile f1, MarkdownFile f2) {
    return f1.getCreationDate().compareTo(f2.getCreationDate());
  }
}
