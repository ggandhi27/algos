package algorithms.codechef.snackdown2019B;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question1 {

  public static String result(String year) {
    switch (year) {
      case "2010":
        return "HOSTED";
      case "2015":
        return "HOSTED";
      case "2016":
        return "HOSTED";
      case "2017":
        return "HOSTED";
      case "2019":
        return "HOSTED";
      default:
        return "NOT HOSTED";
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer noOfTestCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < noOfTestCases; i++) {
      System.out.println(result(br.readLine()));
    }
  }

}
