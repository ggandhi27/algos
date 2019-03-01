package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestPalindromeSubString {

  public static int recursive(char[] str, int i, int j, int count) {
    if (i == str.length || j == -1) {
      return count;
    } else if (str[i] == str[j]) {
      return recursive(str, i + 1, j - 1, count + 1);
    }
    count = Math.max(count,
        Math.max(recursive(str, i + 1, j, 0), recursive(str, i, j - 1, 0)));
    return count;
  }

  public static int result(char[] str) {
    int[][] r = new int[str.length + 1][str.length + 1];
    int max = -1;
    for (int j = str.length - 1, k = 0; j > -1; j--, k++) {
      for (int i = 0; i < str.length; i++) {
        if (str[j] == str[i]) {
          r[k + 1][i + 1] = 1 + r[k][i];
          if (max < r[k + 1][i + 1]) {
            max = r[k + 1][i + 1];
          }
        } else {
          r[k + 1][i + 1] = 0;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      char[] s = br.readLine().toCharArray();
      System.out.println(recursive(s, 0, s.length - 1, 0));
      System.out.println(result(s));
    }
  }
}
