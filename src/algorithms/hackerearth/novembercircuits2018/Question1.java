package algorithms.hackerearth.novembercircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

public class Question1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfTestCases = Integer.parseInt(br.readLine());
    for (int i = 0; i < noOfTestCases; i++) {
      int queueSections = Integer.parseInt(br.readLine().trim());
      int aCount = 0, bCount = 0;
      List<Pair<Integer, String>> pairs = new LinkedList<>();
      for (int j = 0; j < queueSections; j++) {
        String[] str = br.readLine().trim().split(" ");
        int count = Integer.parseInt(str[0]);
        if (str[1].equals("A")) {
          aCount += count;
        } else {
          bCount += count;
        }
        pairs.add(new Pair<>(count, str[1]));
      }
      int gcd = 0;
      if (aCount != 0 && bCount != 0) {
        gcd = new BigInteger(String.valueOf(aCount)).gcd(new BigInteger(String.valueOf(bCount)))
            .intValue();
        aCount = aCount / gcd;
        bCount = bCount / gcd;
      }
      if (gcd == 0) {
        System.out.println(aCount == 0 ? bCount : aCount);
      } else {
        int runningACount = 0, runningBCount = 0, result = 0;
        for (Pair<Integer, String> pair : pairs) {
          if (pair.getValue().equals("A")) {
            if (runningACount >= (runningBCount * aCount) / bCount) {
              runningACount += pair.getKey();
              continue;
            } else {
              runningACount += pair.getKey();
              if (runningBCount >= bCount && runningBCount % bCount == 0
                  && runningACount >= (runningBCount * aCount) / bCount) {
                runningACount -= (runningBCount * aCount) / bCount;
                runningBCount = 0;
                ++result;
              }
            }
          } else {
            if (runningBCount >= (runningACount * bCount) / aCount) {
              runningBCount += pair.getKey();
              continue;
            } else {
              runningBCount += pair.getKey();
              if (runningACount >= aCount && runningACount % aCount == 0
                  && runningBCount >= (runningACount * bCount) / aCount) {
                runningBCount -= (runningACount * bCount) / aCount;
                runningACount = 0;
                ++result;
              }
            }
          }
        }
        System.out.println(result);
      }
    }
  }
}