package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

  public static int result(char[] s1, int l1, char[] s2, int l2) {
    int[][] r = new int[l1 + 1][l2 + 1];
    for (int i = 0; i < l1; i++) {
      for (int j = 0; j < l2; j++) {
        r[i + 1][j + 1] = s1[i] == s2[j] ? r[i][j] + 1 : Math.max(r[i + 1][j], r[i][j + 1]);
      }
    }
    return r[l1][l2];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      String[] ll = br.readLine().split(" ");
      int l1 = Integer.parseInt(ll[0]);
      int l2 = Integer.parseInt(ll[1]);
      char[] s1 = br.readLine().toCharArray();
      char[] s2 = br.readLine().toCharArray();
      System.out.println(result(s1, l1, s2, l2));
    }
  }
}
