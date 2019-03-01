package algorithms.hackerearth.novembercircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfTestCases = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < noOfTestCases; i++) {
      long a = Long.parseLong(br.readLine().trim());
      long b = Long.parseLong(br.readLine().trim());
      long carryAddition = a + b;
      long noCarryAddition = 0;
      for (int j = 0; a > 0 || b > 0; j++) {
        noCarryAddition = ((((a % 10) + (b % 10)) % 10) * (long) Math.pow(10, j)) + noCarryAddition;
        a = a / 10;
        b = b / 10;
      }
      System.out.println(carryAddition - noCarryAddition);
    }
  }
}
