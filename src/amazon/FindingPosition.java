package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Check it against the power of 2 whether the number obtained from 2's power is smaller or equal to
 * N
 */
public class FindingPosition {

  public static void result(int n) {
    int x = 1;
    int pow = 0;
    while (x <= n) {
      x = (int) Math.pow(2, ++pow);
    }
    System.out.println((int) Math.pow(2, --pow));
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int not = Integer.parseInt(br.readLine());
    for (int i = 0; i < not; i++) {
      int N = Integer.parseInt(br.readLine());
      result(N);
    }
  }
}
