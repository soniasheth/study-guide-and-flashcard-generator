package cs3500.pa01.Study.StudySession;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa01.Study.Difficulty;
import cs3500.pa01.Study.Question.Question;
import cs3500.pa01.Study.QuestionBank.StudySessionQuestionBank;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the StudySession (MODEL) Class
 */
class StudySessionTest {
  private final String directory = "./src/test/resources/PA02 Examples/TestQuestions.sr";
  StudySession session;
  Question q1;
  Question q2;
  Question q3;
  Question q4;
  Question q5;

  @BeforeEach
  public void setUp() {
    session = new StudySession();
    session.initializeSessionQuestions(10, directory);
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
   * Tests markedQuestion method when question is marked easy and already easy
   */
  @Test
  public void testMarkedQuestionEasy() {
    //before
    assertEquals(Difficulty.EASY, q1.getDifficulty());
    assertEquals(0,session.getEasyToHard());
    assertEquals(0,session.getHardToEasy());
    assertEquals(0,session.getNumQuestionsAnswered());

    session.markedQuestion(q1, "easy");

    //after
    assertEquals(Difficulty.EASY, q1.getDifficulty());
    assertEquals(0,session.getEasyToHard());
    assertEquals(0,session.getHardToEasy());
    assertEquals(1,session.getNumQuestionsAnswered());
  }

  /**
   * Tests markedQuestion method when question is marked hard and already hard
   */
  @Test
  public void testMarkedQuestionHard() {
    //before
    assertEquals(Difficulty.HARD, q2.getDifficulty());
    assertEquals(0,session.getEasyToHard());
    assertEquals(0,session.getHardToEasy());
    assertEquals(0,session.getNumQuestionsAnswered());

    session.markedQuestion(q2, "hard");

    //after
    assertEquals(Difficulty.HARD, q2.getDifficulty());
    assertEquals(0,session.getEasyToHard());
    assertEquals(0,session.getHardToEasy());
    assertEquals(1,session.getNumQuestionsAnswered());
  }

  /**
   * Tests markedQuestion method when question is marked easy and original hard
   */
  @Test
  public void testMarkedQuestionHardToEasy() {
    //before
    assertEquals(Difficulty.HARD, q4.getDifficulty());
    assertEquals(0,session.getEasyToHard());
    assertEquals(0,session.getHardToEasy());
    assertEquals(0,session.getNumQuestionsAnswered());

    session.markedQuestion(q4, "easy");

    //after
    assertEquals(Difficulty.EASY, q4.getDifficulty());
    assertEquals(0,session.getEasyToHard());
    assertEquals(1,session.getHardToEasy());
    assertEquals(1,session.getNumQuestionsAnswered());
  }

  /**
   * Tests markedQuestion method when question is marked hard and original easy
   */
  @Test
  public void testMarkedQuestionEasyToHard() {
    //before
    assertEquals(Difficulty.EASY, q3.getDifficulty());
    assertEquals(0,session.getEasyToHard());
    assertEquals(0,session.getHardToEasy());
    assertEquals(0,session.getNumQuestionsAnswered());

    session.markedQuestion(q3, "hard");

    //after
    assertEquals(Difficulty.HARD, q3.getDifficulty());
    assertEquals(1,session.getEasyToHard());
    assertEquals(0,session.getHardToEasy());
    assertEquals(1,session.getNumQuestionsAnswered());
  }

  /**
   * Tests the allQuestions method
   */
  @Test
  public void testAllQuestions() {
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
    assertEquals(output, session.allQuestions());
  }

  /**
   * Tests the overridden toString method in the class
   */
  @Test
  public void testsToString() {
    String output =
        """
        Total questions answered: 0
        Questions from easy to hard: 0
        Questions from hard to easy: 0
        Current Counts in Question Bank:
        2 hard questions
        3 easy questions""";
    assertEquals(output, session.toString());
  }

  /**
   * Tests increaseQuestionsAnswered method
   */
  @Test
  public void testIncreaseQuestionsAnswered() {
    assertEquals(0, session.getNumQuestionsAnswered());
    session.increaseQuestionsAnswered();
    assertEquals(1, session.getNumQuestionsAnswered());
  }


  /**
   * Tests the getEasyToHard method
   */
  @Test
  public void testGetEasyToHard() {
    assertEquals(0, session.getEasyToHard());
  }

  /**
   * Tests the getHardToEasy method
   */
  @Test
  public void getHardToEasy() {
    assertEquals(0, session.getHardToEasy());
  }

  /**
   * Tests the getNumQuestionsAnswered method
   */
  @Test
  public void testGetNumQuestionsAnswered() {
    assertEquals(0, session.getNumQuestionsAnswered());
    session.increaseQuestionsAnswered();
    assertEquals(1, session.getNumQuestionsAnswered());
    session.increaseQuestionsAnswered();
    assertEquals(2, session.getNumQuestionsAnswered());
  }

}