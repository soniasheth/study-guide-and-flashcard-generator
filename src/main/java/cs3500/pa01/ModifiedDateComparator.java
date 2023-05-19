package cs3500.pa01;

import java.util.Comparator;

/**
 Represents a comparator that compares two MarkdownFiles by their last modified time
 */
public class ModifiedDateComparator implements Comparator<MarkdownFile> {

  /**
   *Compares two Markdown Files by their last modified time
   *
   * @param f1 the first object to be compared - a Markdown File
   * @param f2 the second object to be compared - a Markdown File
   * @return an int representing whether first object's last modified time
   *         comes before or after the second
   */
  public int compare(MarkdownFile f1, MarkdownFile f2) {
    return f2.getLastModifiedDate().compareTo(f1.getLastModifiedDate());
  }
}
