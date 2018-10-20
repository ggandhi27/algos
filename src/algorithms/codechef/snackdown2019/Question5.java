package algorithms.codechef.snackdown2019;

import java.util.Arrays;

public class Question5 {

  static int distancesum(int arr[], int arr2[], int n) {

    Arrays.sort(arr);
    Arrays.sort(arr2);
    int res = 0, res2 = 0, sum = 0, sum2=0;
    for (int i = 0; i < n; i++) {
      res += (arr[i] * i - sum);
      res2 += (arr2[i] * i - sum2);
      sum += arr[i];
      sum2 += arr2[i];
      System.out.println(res);
      System.out.println(res2);
    }
    return res + res2;
  }

  static int totaldistancesum(int x[],
      int y[], int n) {
    return distancesum(x, y, n);
  }

  public static void main(String[] args) {

    int x[] = {0, 0, 2};
    int y[] = {2, 3, 1};
    int n = x.length;
    System.out.println(totaldistancesum(x,
        y, n));
  }
}