package cs3500.pa01.Study;

/**
 * Represents the difficulty levels of a question
 */
public enum Difficulty {
  EASY("Easy"),
  HARD("Hard");

  private String name;

  Difficulty(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

  public static Difficulty fromString(String name) {
    return Difficulty.valueOf(name.toUpperCase());
  }
}
