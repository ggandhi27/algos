package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PathInAMatrix {

  public static int result(int[][] a, int s) {
    int[][] r = new int[s][s];
    System.arraycopy(a[0], 0, r[0], 0, s);
    for (int i = 0; i < s; i++) {
      for (int j = 0; j < s; j++) {
        if (i + 1 < s) {
          if (j + 1 < s) {
            if (r[i][j] + a[i + 1][j + 1] > r[i + 1][j + 1]) {
              r[i + 1][j + 1] = r[i][j] + a[i + 1][j + 1];
            }
          }
          if (j - 1 > -1) {
            if (r[i][j] + a[i + 1][j - 1] > r[i + 1][j - 1]) {
              r[i + 1][j - 1] = r[i][j] + a[i + 1][j - 1];
            }
          }
          if (r[i][j] + a[i + 1][j] > r[i + 1][j]) {
            r[i + 1][j] = r[i][j] + a[i + 1][j];
          }
        }
      }
    }
    return Arrays.stream(r[s - 1]).max().getAsInt();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int s = Integer.parseInt(br.readLine());
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int[][] a = new int[s][s];
      int x = 0;
      for (int j = 0; j < s; j++) {
        for (int k = 0; k < s; k++) {
          a[j][k] = arr[x];
          x++;
        }
      }
      System.out.println(result(a, s));
    }
  }
}
