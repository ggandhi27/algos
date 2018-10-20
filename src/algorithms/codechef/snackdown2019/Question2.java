package algorithms.codechef.snackdown2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfTestCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < noOfTestCases; i++) {
      br.readLine();
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int flag = 0;
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          ++flag;
          if (flag > 1) {
            break;
          }
        }
      }
      if (flag == 0) {
        System.out.println("YES");
      } else if (flag == 1) {
        if (arr[arr.length - 1] <= arr[0]) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      } else {
        System.out.println("NO");
      }
    }
  }
}
