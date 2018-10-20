package algorithms.hackerearth.augustcircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question2 {

  public static boolean isPrime(long number) {
    int sqrt = new Double(Math.sqrt(number)).intValue();
    boolean flag = true;
    for (int i = 2; i <= sqrt; i++) {
      if (number % i == 0) {
        flag = false;
      }
    }
    return number > sqrt && flag;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int lengthOfArray = Integer.parseInt(br.readLine());
    int[] inputs = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int noOfCuts = Integer.parseInt(br.readLine());
    long runningSum = 0;
    List<Integer> cuts = new ArrayList<>(noOfCuts);
    for (int i = 0; i < lengthOfArray; i++) {
      runningSum += inputs[i];
      if (lengthOfArray - (i + 1) == noOfCuts) {
        cuts.add(i+1);
        for (int j = i + 2; j < lengthOfArray; j++) {
          cuts.add(j);
        }
        break;
      }
      if (isPrime(runningSum)) {
        cuts.add(i + 1);
        noOfCuts--;
      }
    }
    System.out.println(cuts.stream().map(Object::toString).collect(Collectors.joining(" ")));
  }
}
