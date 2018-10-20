package algorithms.hackerearth.nissandigitalsoftwaredeveloperhiringchallenge2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    double[] values = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).sorted().toArray();
    double[] average = new double[values.length];
    double sum = 0;
    for (int i = 0; i < values.length; i++) {
      sum += values[i];
      average[i] = sum / (i + 1);
    }
    int noOfQueries = Integer.parseInt(br.readLine());
    for (int i = 0; i < noOfQueries; i++) {
      double k = Double.parseDouble(br.readLine());
      Integer answer = 0;
      if (average[0] >= k) {
        System.out.println(answer);
        continue;
      } else {
        int start = 0;
        int end = average.length - 1;
        int mid = (start + end) / 2;
        while (start != mid) {
          if (average[mid] < k) {
            start = mid;
          } else {
            end = mid;
          }
          mid = (start + end) / 2;
        }
        if (start == end - 1) {
          if (average[end] < k) {
            start++;
          }
        }
        System.out.println(start + 1);
      }
    }
  }
}
