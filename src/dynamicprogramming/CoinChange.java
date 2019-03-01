package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange {

  public static int result(int[] a, int l, int s) {
    int[] r = new int[s + 1];
    r[0] = 1;
    for (int i = 0; i < l; i++) {
      for (int j = a[i]; j <= s; j++) {
          r[j] = r[j] + r[j - a[i]];
      }
    }
    return r[s];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int l = Integer.parseInt(br.readLine());
      int[] v = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int s = Integer.parseInt(br.readLine());
      System.out.println(result(v, l, s));
    }
  }
}
