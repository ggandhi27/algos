package algorithms.hackerearth.septembercircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question2 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] valueLine1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
        .toArray();

    for (int i = 0; i < valueLine1[0]; i++) {
      br.readLine();
    }

    if (valueLine1[1] > 200000000 && valueLine1[3] < 200000000) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }
}
