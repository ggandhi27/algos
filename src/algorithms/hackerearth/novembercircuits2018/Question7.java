package algorithms.hackerearth.novembercircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question7 {

  static boolean check(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    int j = 0;
    for (int i = 0; i < n && j < m; i++) {
      if (str1.charAt(j) == str2.charAt(i)) {
        j++;
      }
    }
    return (j == m);
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] xoxo = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
        .toArray();

    String[] strings = new String[xoxo[0]];

    for (int i = 0; i < xoxo[0]; i++) {
      strings[i] = br.readLine().trim();
    }
    for (int i = 0; i < xoxo[1]; i++) {
      int[] ss = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
          .toArray();
      if (check(strings[ss[0] - 1], strings[ss[1] - 1]) ||
          check(strings[ss[1] - 1], strings[ss[0] - 1])) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
