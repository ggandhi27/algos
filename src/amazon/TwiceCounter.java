package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TwiceCounter {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int not = Integer.parseInt(br.readLine());
    for (int i = 0; i < not; i++) {
      int N = Integer.parseInt(br.readLine());
      String[] set = br.readLine().split(" ");
      Map<String, Integer> uniqueWord = new HashMap<>();
      for (String s : set) {
        uniqueWord.put(s, uniqueWord.getOrDefault(s, 0) + 1);
      }
      int count = 0;
      for (Entry<String, Integer> entry : uniqueWord.entrySet()) {
        Integer integer = entry.getValue();
        if (integer > 1) {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
