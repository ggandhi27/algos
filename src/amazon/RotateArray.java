package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Rotate an array of size n by d. Divide the array in to two parts 0-(d-1) and d-(n-1) and reverse
 * them. Now reverse the whole array and you will get the answer.
 */
public class RotateArray {

  public static void rotate(int[] arr, Integer n, Integer d) {
    int tmp;
    for (int i = 0, j = d - 1; i < d / 2; i++, j--) {
      tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
    for (int i = d, j = n - 1; i < (d + n) / 2; i++, j--) {
      tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
    for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
      tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
    System.out
        .println(Arrays.stream(arr).mapToObj(Objects::toString).collect(Collectors.joining(" ")));
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int not = Integer.parseInt(br.readLine());
    for (int i = 0; i < not; i++) {
      int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      rotate(arr, size[0], size[1]);
    }
  }
}
