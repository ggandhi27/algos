package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WildCardCharacterMatching {

  public static boolean recursiveResult(char[] s1, char[] s2, int i, int j) {
    if (i == s1.length && j == s2.length) {
      return true;
    }
    if (i == s1.length || j == s2.length) {
      return false;
    } else if (j < s2.length && s1[i] == s2[j] || s1[i] == '?') {
      return recursiveResult(s1, s2, i + 1, j + 1);
    } else if (j < s2.length && s1[i] == '*') {
      return recursiveResult(s1, s2, i + 1, j + 1)
          || recursiveResult(s1, s2, i, j + 1)
          || recursiveResult(s1, s2, i + 1, j);
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      char[] s1 = br.readLine().toCharArray();
      char[] s2 = br.readLine().toCharArray();
      System.out.println(recursiveResult(s1, s2, 0, 0));
    }
  }
}
