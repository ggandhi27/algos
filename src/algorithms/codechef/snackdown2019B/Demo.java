package algorithms.codechef.snackdown2019B;

import java.util.Scanner;

public class Demo {

//  // Returns the count of ways we can
//  // sum S[0...m-1] coins to get sum n
//  static int count(int S[], int m, int n, int depth) {
//    // If n is 0 then there is 1 solution
//    // (do not include any coin)
//    if (n == 0 && depth == 3) {
//      return 1;
//    }
//
//    // If n is less than 0 then no
//    // solution exists
//    if (n < 0 || m <= 0) {
//      return 0;
//    }
//
//    // count is sum of solutions (i)
//    // including S[m-1] (ii) excluding S[m-1]
//    int x = m -1;
//    int firstPartition =  count(S, x, n, depth);
//    int secondPartition = count(S, x, n - S[m - 1], depth + 1);
//    if(secondPartition > 0) {
//      System.out.print(S[x]);
//      if(depth == 0)
//      {
//        System.out.println("----?");
//      }
//    }
//    return firstPartition + secondPartition;
//  }
//
//  // Driver program to test above function
//  public static void main(String[] args) {
//    int arr[] = IntStream.range(1, 11).toArray();
//    int m = arr.length;
//    System.out.println(count(arr, m, 14, 0));
//
//
//  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      if (n < (k * (k + 1)) / 2) {
        System.out.println("-1");
      } else {
        int a[] = new int[k];
        int c = n / k;
        if (k == 2) {
          if (n % 2 == 0) {
            c--;
          }
          a[0] = c;
          a[1] = n - c;
        } else {
          for (int j = k / 2; j < k; j++) {
            a[j] = c++;
          }
          c = n / k;
          for (int j = (k / 2) - 1; j >= 0; j--) {
            a[j] = --c;
          }
          int s = 0;
          for (int j = 0; j < k; j++) {
            s += a[j];
          }
          int d = k - 1;
          while (s != n) {
            a[d--]++;
            if (d == -1) {
              d = k - 1;
            }
            s++;
          }
        }
        long pro = 1, mod = (long) (Math.pow(10, 9)) + 7;
        for (int j = 0; j < k; j++) {
          pro = ((pro % mod) * (a[j] % mod)) % mod;
        }
        for (int j = 0; j < k; j++) {
          pro = ((pro % mod) * ((a[j] - 1) % mod)) % mod;
        }
        System.out.println(pro);


      }
    }
  }
}