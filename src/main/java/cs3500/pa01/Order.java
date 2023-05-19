package cs3500.pa01;

/**
 * Represents the accepted order in which Markdown Files can be ordered
 */
public enum Order {
  //accepted orders
  FILENAME,
  CREATED,
  MODIFIED;

  /**
   * Checks whether a given string is a valid Order enumeration
   *
   * @param value any string
   * @return boolean whether or not the given String value is a valid enum orer
   */

  public static boolean validOrder(String value) {
    //go through all the accepted orders
    for (Order order : Order.values()) {
      //check if equal to the given string
      if (order.name().equalsIgnoreCase(value)) {
        return true;
      }
    }
    return false;
  }

}
