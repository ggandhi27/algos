package algorithms.hackerearth.septembereasy2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question1 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] name = br.readLine().split(" ");
    long a3 = Long.parseLong(name[0]);
    long a4 = Long.parseLong(name[1]);
    long a2 = a4 - a3;
    long a1 = a3 - a2;
    System.out.println(a1 + " " + a2);
  }
}
