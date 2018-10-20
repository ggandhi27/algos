package algorithms.hackerearth.augustcircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Question5 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer noOfTestCases = Integer.parseInt(br.readLine());
    for (int i = 0; i < noOfTestCases; i++) {
      Integer noOfFishes = Integer.parseInt(br.readLine());
      List<Integer> size = new ArrayList<>();
      List<Integer> eating = new ArrayList<>();
      for (int j = 0; j < noOfFishes; j++) {
        String[] sne = br.readLine().split(" ");
        size.add(Integer.parseInt(sne[0]));
        eating.add(Integer.parseInt(sne[1]));
      }
      Integer max = eating.stream().reduce(Integer::max).get();
      int count = 0;
      for (Integer j : size) {
        if (j > max) {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
