package algorithms.codechef.snackdown2019B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question3 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer noOfTestCases = Integer.parseInt(br.readLine());

    for (int i = 0; i < noOfTestCases; i++) {
      int[] someValues = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
          .toArray();
      int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
          .toArray();
      Arrays.sort(sequence);
      int waitingTime = someValues[1] * someValues[3];
      int minWaitingTime = waitingTime;
      int lastIncrementedSecond = 0;
      int currentWaitingTime;
      for (int j = 0; j < someValues[0]; j++) {
        if (sequence[j] <= someValues[2]) {
          currentWaitingTime = waitingTime - (sequence[j] - lastIncrementedSecond);
          if (currentWaitingTime < minWaitingTime) {
            minWaitingTime = currentWaitingTime;
          }
          waitingTime = currentWaitingTime + someValues[3] - 1;
          lastIncrementedSecond = sequence[j] + 1;
        } else {
          break;
        }
      }
      if (lastIncrementedSecond < someValues[2]) {
        currentWaitingTime = waitingTime - (someValues[2] - lastIncrementedSecond);
        if (currentWaitingTime < minWaitingTime) {
          minWaitingTime = currentWaitingTime;
        }
      }
      System.out.println(minWaitingTime + someValues[3]);
    }
  }
}
