package cs3500.pa01.Study.StudyViewer;

import java.io.IOException;

public class MockStudyView implements View {

  Appendable ap; //give it a string builder

  public MockStudyView(Appendable ap){
    this.ap = ap;
  }

  @Override
  public String getUserResponse(String prompt) throws IOException {
    ap.append("user response");
    return "";
  }

  @Override
  public String showUserOptions() throws IOException {
    ap.append("showUserOptions");
    return "";
  }

  @Override
  public void showElement(String element) throws IOException {
    ap.append("show element");
  }


}
