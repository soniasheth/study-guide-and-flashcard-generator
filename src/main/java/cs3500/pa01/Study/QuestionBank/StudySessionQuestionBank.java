package cs3500.pa01.Study.QuestionBank;

import cs3500.pa01.Study.Question.Question;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Represents a Question Bank for a Study Session with hard + easy questions
 */
public class StudySessionQuestionBank extends QuestionBank {
  //fields
  private int numHardQuestions;
  private int numEasyQuestions;
  ArrayList<Question> hardQuestions;
  ArrayList<Question> easyQuestions;

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

  //add try catches
  // add more ways to process answer and difficulty
  @Override
  public void initializeQuestions() {
    Scanner fileScan = null;
    try {
      fileScan = new Scanner(Paths.get(link));
    } catch (IOException e) {
      throw new IllegalArgumentException("Path is invalid.");
    }
    while(fileScan.hasNextLine()) {
      //gets the question metadata according to the format of the Question .sr file
      // add a try catch
      String question = fileScan.nextLine();
      String answer = fileScan.nextLine();
      String difficulty = fileScan.nextLine();
      Question q = new Question(question, answer, difficulty);
      if(difficulty.contains("Hard")) {
        hardQuestions.add(q);
      }
      else if(difficulty.contains("Easy")) {
        easyQuestions.add(q);
      }
      allQuestions.add(q);
      // move past the space between each question in the document
      if(fileScan.hasNextLine()) {
        fileScan.nextLine();
      }
    }
  }

  @Override
  public ArrayList<Question> generateSessionQuestions(int questionNum) {
    ArrayList<Question> sessionQuestions = new ArrayList<>();
    //shuffles the lists
    Collections.shuffle(easyQuestions);
    Collections.shuffle(hardQuestions);
    if(questionNum <= easyQuestions.size() + hardQuestions.size()) {
      //num of questions is more than the total questions - add all hard questions, then add easy
      int easyCounter = 0;
      for(int i = 0; i < questionNum; i++) {
        if(i < hardQuestions.size()) {
          sessionQuestions.add(hardQuestions.get(i));
        } else {
          sessionQuestions.add(easyQuestions.get(easyCounter));
          easyCounter++;
        }
      }
    } else {
      //number of questions is less than total questions - add them all
      for(Question x : hardQuestions) {
        sessionQuestions.add(x);
      }
      for(Question x : easyQuestions) {
        sessionQuestions.add(x);
      }
    }
    return sessionQuestions; //want to make sure the size of this arraylist question num - exception
  }

  public int getNumEasyQuestions() {
    return numEasyQuestions;
  }

  public int getNumHardQuestions() {
    return numHardQuestions;
  }

  public void increaseNumEasyQue() {
    numEasyQuestions++;
    numHardQuestions--;
  }

  public void increaseNumHardQue() {
    numHardQuestions++;
    numEasyQuestions--;
  }

}