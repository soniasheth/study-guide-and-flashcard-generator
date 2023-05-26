package cs3500.pa01.Study.QuestionBank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa01.Study.Difficulty;
import cs3500.pa01.Study.Question.Question;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the StudySessionQuestionBank Class which extends Question Bank
 */
class StudySessionQuestionBankTest {

  //fields
  private final String directory = "./src/test/resources/PA02 Examples/TestQuestions.sr";
  StudySessionQuestionBank questionBank;
  Question q1;
  Question q2;
  Question q3;
  Question q4;
  Question q5;


  /**
   * Before each test - set up
   */
  @BeforeEach
  public void setUp() {
    questionBank = new StudySessionQuestionBank(directory);
    q1 = new Question("What is the capital of Canada?",
        "Answer: The capital is Ottawa.", Difficulty.EASY);
    q2 = new Question("Which country is known as the Land of the Rising Sun?",
        "Answer: Japan.", Difficulty.HARD);
    q3 = new Question("What is the largest river in Africa?",
        "Answer: The largest river is the Nile River.", Difficulty.EASY);
    q4 = new Question("What is the tallest mountain in North America?",
        "Answer: The tallest mountain is Denali (also known as Mount McKinley).", Difficulty.HARD);
    q5 = new Question("Which continent is the driest inhabited continent on Earth?",
        "Answer: Australia.", Difficulty.EASY);
  }

  /**
   * Tests the intializeQuestion method (success)
   */
  @Test
  public void testIntializeQuestionsSuccess() {
    //initilize questions is called in the constructor and so the lists are never empty
    ArrayList<Question> all = new ArrayList<>(Arrays.asList(q1, q2, q3, q4, q5));
    ArrayList<Question> easy = new ArrayList<>(Arrays.asList(q1, q3, q5));
    ArrayList<Question> hard = new ArrayList<>(Arrays.asList(q2, q4));

    assertEquals(5, questionBank.getAllQuestions().size());
    for (int i = 0; i < questionBank.getAllQuestions().size(); i++) {
      assertEquals(all.get(i), questionBank.getAllQuestions().get(i));
    }

    assertEquals(2, questionBank.getHardQuestions().size());
    for (int i = 0; i < questionBank.getHardQuestions().size(); i++) {
      assertEquals(hard.get(i), questionBank.getHardQuestions().get(i));
    }

    assertEquals(3, questionBank.getEasyQuestions().size());
    for (int i = 0; i < questionBank.getEasyQuestions().size(); i++) {
      assertEquals(easy.get(i), questionBank.getEasyQuestions().get(i));
    }
  }

  /**
   * Tests the initializeQuestions function (fails)
   */
  @Test
  public void testInitializeQuestionsFail() {
    //called in constructor so need to test creating a new object
    assertThrows(
        IllegalArgumentException.class,
        () -> new StudySessionQuestionBank("invalid"));
  }

  /**
   * Test generateSessionQuestion method with a requested question amount above the amount
   *     of questions in the bank
   */
  @Test
  public void testGenerateSessionQuestionsAbove() {
    //requested question amount above amount in bank
    ArrayList<Question> bank1 = questionBank.generateSessionQuestions(10, 100);
    ArrayList<Question> expectedBank1 = new ArrayList<>(Arrays.asList(q2, q4, q1, q5, q3));
    assertEquals(5, bank1.size());
    for (int i = 0; i < bank1.size(); i++) {
      assertEquals(expectedBank1.get(i), bank1.get(i));
    }
  }

  /**
   * Test generateSessionQuestion method with a requested question amount equal to the amount
   *     of questions in the bank
   */
  @Test
  public void testGenerateSessionQuestionsEqual() {
    //requested question amount equal amount in bank
    ArrayList<Question> bank1 = questionBank.generateSessionQuestions(5, 100);
    ArrayList<Question> expectedBank1 = new ArrayList<>(Arrays.asList(q2, q4, q1, q5, q3));
    assertEquals(5, bank1.size());
    for (int i = 0; i < bank1.size(); i++) {
      assertEquals(expectedBank1.get(i), bank1.get(i));
    }
  }

  /**
   * Test generateSessionQuestion method with a requested question amount below the amount
   *     of questions in the bank AND equal to the amount of hard questions
   */
  @Test
  public void testGenerateSessionQuestionsBelowOnlyHard() {
    //requested question amount below amount in bank , but equal to # of hard questions
    ArrayList<Question> bank1 = questionBank.generateSessionQuestions(2, 100);
    ArrayList<Question> expectedBank1 = new ArrayList<>(Arrays.asList(q2, q4));
    assertEquals(2, bank1.size());
    for (int i = 0; i < bank1.size(); i++) {
      assertEquals(expectedBank1.get(i), bank1.get(i));
    }
  }

  /**
   * Test generateSessionQuestion method with a requested question amount below the amount
   *     of questions in the bank but above the # of hard questions
   */
  @Test
  public void testGenerateSessionQuestionsBelowEasyAndHard() {
    //requested question amount below amount in bank, above # of hard questions
    ArrayList<Question> bank1 = questionBank.generateSessionQuestions(3, 100);
    ArrayList<Question> expectedBank1 = new ArrayList<>(Arrays.asList(q2, q4, q1));
    assertEquals(3, bank1.size());
    for (int i = 0; i < bank1.size(); i++) {
      assertEquals(expectedBank1.get(i), bank1.get(i));
    }
  }

  /**
   * Tests the toString method
   */

  @Test
  public void testToString() {
    String output =
            """
            What is the capital of Canada?
            Answer: The capital is Ottawa.
            Difficulty: Easy
                        
            Which country is known as the Land of the Rising Sun?
            Answer: Japan.
            Difficulty: Hard
                        
            What is the largest river in Africa?
            Answer: The largest river is the Nile River.
            Difficulty: Easy
                        
            What is the tallest mountain in North America?
            Answer: The tallest mountain is Denali (also known as Mount McKinley).
            Difficulty: Hard
                        
            Which continent is the driest inhabited continent on Earth?
            Answer: Australia.
            Difficulty: Easy
            
            """;
    assertEquals(output, questionBank.toString());
  }

  /**
   * Tests the getNumEasyQuestions method
   */
  @Test
  public void testGetNumEasyQuestions() {
    assertEquals(3, questionBank.getNumEasyQuestions());
  }

  /**
   * Tests the getNumHardQuestions function
   */
  @Test
  public void testGetNumHardQuestions() {
    assertEquals(2, questionBank.getNumHardQuestions());
  }

  /**
   * Tests the increaseNumEasyQue method
   */
  @Test
  public void testIncreaseNumEasyQue() {
    assertEquals(3, questionBank.getNumEasyQuestions());
    assertEquals(2, questionBank.getNumHardQuestions());
    questionBank.increaseNumEasyQue();
    assertEquals(4, questionBank.getNumEasyQuestions());
    assertEquals(1, questionBank.getNumHardQuestions());
  }

  /**
   * Tests the increaseNumHardQue method
   */
  @Test
  public void testIncreaseNumHardQue() {
    assertEquals(3, questionBank.getNumEasyQuestions());
    assertEquals(2, questionBank.getNumHardQuestions());

    questionBank.increaseNumHardQue();

    assertEquals(2, questionBank.getNumEasyQuestions());
    assertEquals(3, questionBank.getNumHardQuestions());
  }

  /**
   * Tests the getHardQuestions method
   */

  @Test
  public void testGetHardQuestions() {
    ArrayList<Question> hard = new ArrayList<>(Arrays.asList(q2, q4));
    assertEquals(hard, questionBank.getHardQuestions());
  }

  /**
   * Tests the getEasyQuestions method
   */
  @Test
  public void testGetEasyQuestions() {
    ArrayList<Question> easy = new ArrayList<>(Arrays.asList(q1, q3, q5));
    assertEquals(easy, questionBank.getEasyQuestions());
  }

  /**
   * Tests getAllQuestions method
   */
  @Test
  public void testGetAllQuestions() {
    ArrayList<Question> all = new ArrayList<>(Arrays.asList(q1, q2, q3, q4, q5));
    assertEquals(all, questionBank.getAllQuestions());
  }



}