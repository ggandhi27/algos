package algorithms.hackerearth.nissandigitalsoftwaredeveloperhiringchallenge2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int inputLines = Integer.parseInt(br.readLine());
    int[] ones = new int[10000000];
    for (int i = 0; i < inputLines; i++) {
      char[] chars = br.readLine().toCharArray();
      for (int j = 0; j < chars.length; j++) {
        if (chars[j] == '1') {
          ones[j] = 1;
        }
      }
    }
    int count = 0;
    for (int i = 0; i < 1000000; i++) {
      if (ones[i] == 1) {
        count++;
      }
    }
    if (count % 2 == 0) {
      System.out.println("A");
    } else {
      System.out.println("B");
    }
    System.out.println(count);
  }

}
