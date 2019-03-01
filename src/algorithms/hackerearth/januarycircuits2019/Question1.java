package algorithms.hackerearth.januarycircuits2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Question1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int no = Integer.parseInt(br.readLine());
    long[] set1 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    long[] set2 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    Arrays.sort(set1);
    Arrays.sort(set2);
    BigInteger sum = BigInteger.ZERO;
    for (int i = 0; i < no; i++) {
      sum = sum.add(BigInteger.valueOf(Math.abs(set1[i] - set2[i])));
    }
    System.out.println(sum.mod(BigInteger.valueOf(1000000007L)));
  }
}
