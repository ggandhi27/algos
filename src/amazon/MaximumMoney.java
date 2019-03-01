package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Thief can not rob the adjacent house so it becomes a question of even and odd. If its odd is
 * answer else anything odd / even.
 */
public class MaximumMoney {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfTestCases = Integer.parseInt(br.readLine());
    for (int i = 0; i < noOfTestCases; i++) {
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      if ((arr[0] & 1) == 1) {
        System.out.println(arr[1] * (arr[0] / 2 + 1));
      } else {
        System.out.println(arr[1] * (arr[0] / 2));
      }
    }
  }
}
