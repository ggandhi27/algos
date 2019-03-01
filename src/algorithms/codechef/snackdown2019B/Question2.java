package algorithms.codechef.snackdown2019B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer noOfTestCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < noOfTestCases; i++) {
      String[] lengthOfSequenceAndMaxAllowedChanges = br.readLine().split(" ");
      int maxAllowedChanges = Integer.parseInt(lengthOfSequenceAndMaxAllowedChanges[1]);
      int[] sequence = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt).toArray();
      int count = 0;
      for (Integer integer : sequence) {
        if (integer > 1) {
          ++count;
        }
      }
      System.out.println(maxAllowedChanges < count ? "NO" : "YES");
    }
  }
}

