package cs3500.pa01.Study.StudyViewer;

import java.io.IOException;
import java.util.Scanner;

public interface View {


  String getUserResponse(String prompt) throws IOException;

  String showUserOptions() throws IOException;

  void showElement(String element) throws IOException;
}
