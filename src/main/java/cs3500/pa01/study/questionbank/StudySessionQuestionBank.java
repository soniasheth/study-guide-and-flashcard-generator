package cs3500.pa01.study.questionbank;

import cs3500.pa01.LineProcessor;
import cs3500.pa01.study.Difficulty;
import cs3500.pa01.study.question.Question;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents a Question Bank for a Study Session with hard + easy questions
 */
public class StudySessionQuestionBank extends QuestionBank {
  //fields
  private int numHardQuestions;
  private int numEasyQuestions;
  private ArrayList<Question> hardQuestions;
  private ArrayList<Question> easyQuestions;


  /**
   * Initializes Study Session Object
   *
   * @param link Strink link to the .sr file with the questions
   */
  public StudySessionQuestionBank(String link) {
    super(link);
    this.hardQuestions = new ArrayList<>();
    this.easyQuestions = new ArrayList<>();
    this.numHardQuestions = 0;
    this.numEasyQuestions = 0;
    initializeQuestions();
  }

  /**
   * Reads the file of questions and populates the two banks of questions: hard questions and
   *     easy questions.
   *
   */
  @Override
  public void initializeQuestions() {
    Scanner fileScan = null;
    try {
      fileScan = new Scanner(Paths.get(link));
    } catch (IOException e) {
      throw new IllegalArgumentException("Path is invalid.");
    }
    while (fileScan.hasNextLine()) {
      //gets the question metadata according to the format of the Question .sr file
      // assume that the .sr is properly formatted according to my specifications
      LineProcessor lp = new LineProcessor();
      String question = fileScan.nextLine();
      String answer = fileScan.nextLine();
      //get the difficulty of the question and convert to enum value
      String difficulty = lp.removeWord(fileScan.nextLine(), "Difficulty:");
      Difficulty enumdifficulty = Difficulty.fromString(difficulty);
      //create question
      Question q = new Question(question, answer, enumdifficulty);
      //add question to correct bank / arraylist
      if (enumdifficulty.equals(Difficulty.HARD)) {
        hardQuestions.add(q);
        numHardQuestions++;
      } else if (enumdifficulty.equals(Difficulty.EASY)) {
        easyQuestions.add(q);
        numEasyQuestions++;
      }
      allQuestions.add(q);
      // move past the space between each question in the document (format of the document)
      if (fileScan.hasNextLine()) {
        fileScan.nextLine();
      }
    }
  }

  /**
   * Generates an ArrayList of random questions for the study session
   *
   * @param questionNum the amount of questions wanted for the session
   * @param seed for randomization
   * @return arraylist of randomized questions for the session (hard questions come first)
   */
  @Override
  public ArrayList<Question> generateSessionQuestions(int questionNum, int seed) {
    ArrayList<Question> sessionQuestions = new ArrayList<>();
    //shuffles the lists
    Collections.shuffle(easyQuestions, new Random(seed));
    Collections.shuffle(hardQuestions, new Random(seed));

    if (questionNum <= easyQuestions.size() + hardQuestions.size()) {
      // questionNum is less than the total questions in the question bank
      // add all hard questions, add easy to fill in
      int easyCounter = 0;
      for (int i = 0; i < questionNum; i++) {
        // if there are hard questions, add first
        if (i < hardQuestions.size()) {
          sessionQuestions.add(hardQuestions.get(i));
        } else {
          sessionQuestions.add(easyQuestions.get(easyCounter));
          easyCounter++;
        }
      }
    } else {
      //questionNum is more than total questions - add them all
      for (Question x : hardQuestions) {
        sessionQuestions.add(x);
      }
      for (Question x : easyQuestions) {
        sessionQuestions.add(x);
      }
    }
    return sessionQuestions;
  }

  /**
   * Gets the number of easy questions in the question bank
   *
   * @return number od easy questions
   *
   */
  public int getNumEasyQuestions() {
    return numEasyQuestions;
  }

  /**
   * Get the number of hard questions in the question bank
   *
   * @return the numer of hard questions
   *
   */
  public int getNumHardQuestions() {
    return numHardQuestions;
  }

  /**
   * Increases the number of easy questions, decreases the number of hard questions
   */
  public void increaseNumEasyQue() {
    numEasyQuestions++;
    numHardQuestions--;
  }

  /**
   * Increases the number of hard questions, decreases the number of easy questions
   */
  public void increaseNumHardQue() {
    numHardQuestions++;
    numEasyQuestions--;
  }

  /**
   * Gets the ArrayList of hard questions - needed for testing
   *
   * @return arraylist of hard questions
   */
  public ArrayList<Question> getHardQuestions() {
    return hardQuestions;
  }

  /**
   * Gets the Arraylist of easy questions - needed for testing
   *
   * @return arraylist of easy questions
   *
   */
  public ArrayList<Question> getEasyQuestions() {
    return easyQuestions;
  }

}
