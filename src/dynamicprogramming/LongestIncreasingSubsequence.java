package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static int result(int[] s, int l) {
    int[] r = new int[s.length];
    Arrays.fill(r, 1);
    for(int i=0;i<l;i++) {
      for(int j=i+1;j<l;j++) {
        if(s[j] > s[i] && r[j] < r[i] + 1) {
          r[j] = r[i] + 1;
        }
      }
    }
    return Arrays.stream(r).max().getAsInt();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int l = Integer.parseInt(br.readLine());
      int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      System.out.println(result(s, l));
    }
  }
}
