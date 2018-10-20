package algorithms.hackerearth.augustcircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Question1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfTestCases = Integer.parseInt(br.readLine());
    for (int i = 0; i < noOfTestCases; i++) {
      long result;
      long[] inputs = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
      inputs[4] = inputs[4] - inputs[0];
      if (inputs[4] < 0) {
        inputs[4] = 0;
      }
      inputs[0] = (inputs[1] * inputs[2]) + inputs[3];
      long settlement = inputs[4] % inputs[0];
      result = (inputs[4] / inputs[0]) * (inputs[2] + 1);
      if (settlement != 0) {
        result += settlement > inputs[1] * inputs[2] ?
            settlement / inputs[1] + 1 : settlement % inputs[1] == 0 ?
            settlement / inputs[1] : settlement / inputs[1] + 1;
      }
      System.out.println(result);
    }
  }
}
