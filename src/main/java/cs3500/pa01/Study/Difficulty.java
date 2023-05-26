package cs3500.pa01.Study;

/**
 * Represents the difficulty levels of a question
 */
public enum Difficulty {
  EASY("Easy"),
  HARD("Hard");

  private String name;

  /**
   * Instantiates enum
   *
   * @param name the name of the enum
   */
  Difficulty(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the enum
   *
   * @return name
   */
  public String toString() {
    return name;
  }

  /**
   * Takes in a string and converts it to the correct Difficulty (enum) type
   *
   * @param name input string
   * @return Difficulty type of the string
   */
  public static Difficulty fromString(String name) {
    return Difficulty.valueOf(name.toUpperCase());
  }
}
