package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxProductSubArray {

  public static int result(int[] arr, int l) {
    int firstNegative = 1;
    int lastNegative = 1;
    int product = 1;
    int max = 0;
    for (int i = 0; i < l; i++) {
      if (arr[i] == 0) {

        max = max < product ? product : max;
        firstNegative = 1;
        lastNegative = 1;
        product = 1;
      } else {
        product *= arr[i];
        if (arr[i] < 0) {
          if (firstNegative == 1) {
            firstNegative = product;
          }
          lastNegative = arr[i];
        } else {
          if (lastNegative != 1) {
            lastNegative *= arr[i];
          }
        }
      }
    }
    if (product < 0) {

    }
    max = max < product ? product : max;
    return max;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int not = Integer.parseInt(br.readLine());
    for (int i = 0; i < not; i++) {
      int l = Integer.parseInt(br.readLine());
      int[] arr = Arrays.stream((br.readLine()).split(" "))
          .mapToInt(Integer::parseInt).toArray();
      System.out.println(result(arr, l));
    }
  }
}
