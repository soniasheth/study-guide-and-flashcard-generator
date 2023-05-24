package cs3500.pa01;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

  public <T> ArrayList<T> shuffleArraylist(Random random, ArrayList<T> orginalList) {
    ArrayList shuffled = new ArrayList<>(orginalList);
    for (int i = shuffled.size() - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      swapElements(shuffled, i, j);
    }
    return shuffled;
  }


  private static <T> void swapElements(ArrayList<T> list, int i, int j) {
    T temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}
