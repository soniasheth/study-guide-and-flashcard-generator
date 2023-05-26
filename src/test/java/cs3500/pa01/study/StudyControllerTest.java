package cs3500.pa01.study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa01.study.studysession.StudySessionMock;
import cs3500.pa01.study.studyviewer.MockStudyView;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Tests the Study Controller Class
 */
class StudyControllerTest {
  StudyController controller;

  /**
   * Tests the run method with a user input of 1
   *
   * @throws IOException if invalid
   */
  @Test
  public void testStudyControllerUserInput1() throws IOException {
    MockStudyView mockView = new MockStudyView("1");
    StudySessionMock mockModel = new StudySessionMock();

    controller = new StudyController(mockView, mockModel);
    controller.run();
    String testView = "showelement userresponse userresponse"
        + " showelement showUserOptions showelement showelement ";
    String testModel = "init markedQuestion allQuestions ";
    assertEquals(mockView.getAppendable(), testView);
    assertEquals(mockModel.build.toString(), testModel);
  }

  /**
   * Tests the run method with a user input of 2
   *
   * @throws IOException if invalid
   */
  @Test
  public void testStudyControllerUserInput2() throws IOException {
    MockStudyView mockView = new MockStudyView("2");
    StudySessionMock mockModel = new StudySessionMock();

    controller = new StudyController(mockView, mockModel);
    controller.run();
    String testView = "showelement userresponse userresponse"
        + " showelement showUserOptions showelement showelement ";
    String testModel = "init markedQuestion allQuestions ";
    assertEquals(mockView.getAppendable(), testView);
    assertEquals(mockModel.build.toString(), testModel);
  }

  /**
   * Tests the run method with a user input of 3
   *
   * @throws IOException if invalid
   */
  @Test
  public void testStudyControllerUserInput3() throws IOException {
    MockStudyView mockView = new MockStudyView("3");
    StudySessionMock mockModel = new StudySessionMock();

    controller = new StudyController(mockView, mockModel);
    controller.run();
    String testView = "showelement userresponse userresponse"
        + " showelement showUserOptions showelement showelement showelement ";
    String testModel = "init increase allQuestions ";
    assertEquals(mockView.getAppendable(), testView);
    assertEquals(mockModel.build.toString(), testModel);
  }

  /**
   * Tests the run method with a user input of 4
   *
   * @throws IOException if invalid
   */
  @Test
  public void testStudyControllerUserInput4() throws IOException {
    MockStudyView mockView = new MockStudyView("4");
    StudySessionMock mockModel = new StudySessionMock();

    controller = new StudyController(mockView, mockModel);
    controller.run();
    String testView = "showelement userresponse userresponse"
        + " showelement showUserOptions showelement showelement ";
    String testModel = "init allQuestions ";
    assertEquals(mockView.getAppendable(), testView);
    assertEquals(mockModel.build.toString(), testModel);
  }

  /**
   * Tests the run method with a user input of 5 (throws exception)
   *
   * @throws IOException if invalid
   */
  @Test
  public void testStudyControllerUserInputDefault() {
    MockStudyView mockView = new MockStudyView("5");
    StudySessionMock mockModel = new StudySessionMock();

    controller = new StudyController(mockView, mockModel);
    assertThrows(
        IllegalArgumentException.class,
        () -> controller.run());
  }





}