package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Sort the array and find the difference between adjacent numbers, which so ever is minimum is the
 * answer.
 */
public class MinimumDifferencePair {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int not = Integer.parseInt(br.readLine());
    for (int i = 0; i < not; i++) {
      int size = Integer.parseInt(br.readLine());
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      Arrays.sort(arr);
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < size - 1; j++) {
        if (arr[j + 1] - arr[j] < min) {
          min = arr[j + 1] - arr[j];
        }
      }
      System.out.println(min);
    }
  }
}
