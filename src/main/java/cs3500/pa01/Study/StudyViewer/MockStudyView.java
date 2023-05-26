package cs3500.pa01.Study.StudyViewer;

import java.io.IOException;

public class MockStudyView implements View {

  Appendable ap;
  private String choice;

  public MockStudyView(){
    this.ap = new StringBuilder();
  }

  public MockStudyView(String choice){
    this.ap = new StringBuilder();
    this.choice = choice;
  }

  @Override
  public String getUserResponse(String prompt) throws IOException {
    ap.append("userresponse ");
    return "1";
  }

  @Override
  public String showUserOptions() throws IOException {
    ap.append("showUserOptions ");
    return choice;
  }

  @Override
  public void showElement(String element) throws IOException {
    ap.append("showelement ");
  }

  public String getAppendable() {
    return ap.toString();
  }


}
