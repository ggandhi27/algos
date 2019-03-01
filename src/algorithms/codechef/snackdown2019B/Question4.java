package algorithms.codechef.snackdown2019B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Question4 {

  static Integer maxProduct, mod = 1000_000_007;

  static int count(int array[], int lengthOfArray, int sum, int depth, int maxDepth,
      Integer currentProduct) {
    if (sum == 0 && depth == maxDepth) {
      if (currentProduct > maxProduct) {
        maxProduct = currentProduct;
      }
      return 1;
    }
    if (sum < 0 || lengthOfArray <= 0) {
      return 0;
    }
    int x = lengthOfArray - 1;
    int firstPartition = count(array, x, sum, depth, maxDepth, currentProduct);
    int secondPartition = count(array, x, sum - array[lengthOfArray - 1], depth + 1, maxDepth,
        ((currentProduct % mod) * (((array[x] * array[x]) - array[x]) % mod)) % mod);
    return firstPartition + secondPartition;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer noOfTestCases = Integer.parseInt(br.readLine());
    for (int i = 0; i < noOfTestCases; i++) {
      int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      if (((values[1] * (values[1] + 1)) / 2) > values[0]) {
        System.out.println(-1);
        continue;
      }
      int[] array = IntStream.range(1, (values[0] - ((values[1] * (values[1] - 1)) / 2)) + 1)
          .toArray();
      maxProduct = 1;
      int noOfSolution = count(array, array.length, values[0], 0, values[1], 1);
      System.out.println(noOfSolution > 0 ? maxProduct : -1);
    }
  }
}
