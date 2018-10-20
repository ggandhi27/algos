package algorithms.hackerearth.julycircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Question1 {

  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfTestCases = Integer.parseInt(br.readLine());

    IntStream.range(0, noOfTestCases).forEach(t -> {
      try {
        String[] inputs = br.readLine().split(" ");
        long n = Long.parseLong(inputs[0]);
        long a = Long.parseLong(inputs[1]);
        long b = Long.parseLong(inputs[2]);
        long x1 = ((b * n) / (a + b));
        long x2 = x1 + 1;
        long y1 = n - x1;
        long y2 = n - x2;
        System.out.println(Math.min((a * x1 * x1) + (b * y1 * y1), (a * x2 * x2) + (b * y2 * y2)));
      } catch (Exception ignored) {
      }
    });
  }
}
