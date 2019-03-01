package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Take a temporary variable and keep swap the values in circular. And it will be dealt by doing it
 * for outer circle first then going inside it. N/2
 */
public class Rotate2DArray {

  public static void result(int[][] arr, int N) {

    for (int i = 0; i < N / 2; i++) {
      for (int j = i; j < N - i - 1; j++) {
        int tmp = arr[j][i];
        arr[j][i] = arr[N - 1 - i][j];
        arr[N - 1 - i][j] = arr[N - 1 - j][N - 1 - i];
        arr[N - 1 - j][N - 1 - i] = arr[i][N - 1 - j];
        arr[i][N - 1 - j] = tmp;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int k = 0; k < N; k++) {
      for (int m = 0; m < N; m++) {
        sb.append(arr[k][m]).append(" ");
      }
    }
    System.out.println(sb.toString().substring(0, sb.length() - 1));
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int not = Integer.parseInt(br.readLine());
    for (int i = 0; i < not; i++) {
      int N = Integer.parseInt(br.readLine());
      int[][] arr = new int[N][N];
      int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int l = 0;
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          arr[j][k] = x[l];
          l++;
        }
      }
      result(arr, N);
    }
  }
}
