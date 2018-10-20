package algorithms.dynamicprogramming;

import java.util.Arrays;

public class RodCutting {

  public static void calc(int[] values, int m) {
    int[] maximize = new int[m + 1];
    Arrays.fill(maximize, 0);
    int max = maximize[m];
    for (int i = 0; i < m; i++) {
      for (int j = i; j < m; j++) {
        maximize[j + 1] = Math.max(maximize[j + 1], values[i] + maximize[j - i]);
      }
      max = maximize[m];
    }
    System.out.println(max);
  }

  public static void main(String[] args) {
    int[] values1 = {1, 5, 8, 9, 10, 17, 17, 20};
    calc(values1, values1.length);
    int[] values2 = {3, 5, 8, 9, 10, 17, 17, 20};
    calc(values2, values2.length);
  }
}
