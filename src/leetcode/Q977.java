package leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class Q977 {

  public int[] sortedSquares(int[] A) {
    int[] x = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      x[i] = (int) Math.pow(A[i], 2);
    }
    Arrays.sort(x);
    return x;
  }

  public static void main(String[] args) {

  }
}
