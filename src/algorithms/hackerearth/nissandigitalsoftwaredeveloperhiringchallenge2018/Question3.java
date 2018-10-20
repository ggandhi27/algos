package algorithms.hackerearth.nissandigitalsoftwaredeveloperhiringchallenge2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question3 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");

    int noe = Integer.parseInt(inputs[0]);
    int size = Integer.parseInt(inputs[1]);
    int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    long sum = values[0];
    long maxsum = values[0];
    for (int i = noe - 1; i > noe - size; i--) {
      sum += values[i];
      maxsum = sum;
    }

    for (int i = noe - size + 1, j = 1; i < noe; i++, j++) {
      sum = sum + values[j] - values[i];
      if (maxsum < sum) {
        maxsum = sum;
      }
    }

    System.out.println(maxsum);
  }
}
