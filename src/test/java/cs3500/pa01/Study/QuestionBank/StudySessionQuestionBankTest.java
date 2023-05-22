package cs3500.pa01.Study.QuestionBank;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa01.Study.Question.Question;
import org.junit.jupiter.api.Test;

class StudySessionQuestionBankTest {

  StudySessionQuestionBank q = new StudySessionQuestionBank("/Users/soniasheth/Library/CloudStorage/OneDrive-NortheasternUniversity/Sophmore Year/Summer 1/OOD/pa02-soniasheth/SampleQuestionFile.sr");
  Question q1 = new Question("What is the capital of Washington?", "Answer: Olympia", "Difficulty: Easy");
  Question q2 = new Question ("What are the basic methods of circuit analysis?", "Answer: KVL, KCL, Mesh current, and Node Voltage", "Difficulty: Hard");



}