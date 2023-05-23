package cs3500.pa01.Study;

/**
 * Represents the options has when seeing a question
 */
public enum UserOptions {
  EASY("1"),
  HARD("2"),
  SHOW_ANSWER("3"),
  EXIT("4");

  private final String val;

  UserOptions(String val) {
    this.val = val;
  }

  public static UserOptions fromVal(String val) {
    for (UserOptions option : UserOptions.values()) {
      if (option.val.equals(val)) {
        return option;
      }
    }
    // Handle the case where the input value does not match any enum value
    throw new IllegalArgumentException("Invalid value.");
  }

}
