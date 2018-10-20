package algorithms.hackerearth.julycircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Question2 {

  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<Integer> a = new HashSet<>(Integer.parseInt(br.readLine()));
    Arrays.stream(br.readLine().split(" ")).forEach(x -> a.add(Integer.parseInt(x)));
    Set<Integer> c = new HashSet<>(Integer.parseInt(br.readLine()));
    Arrays.stream(br.readLine().split(" ")).forEach(x -> c.add(Integer.parseInt(x)));
    Set<Integer> b = new TreeSet<>();
    c.forEach(x -> a.forEach(y -> {
      int tmp = x - y;
      boolean flag = true;
      for (Integer z : a) {
        if (!c.contains(z + tmp)) {
          flag = false;
          break;
        }
      }
      if (flag) {
        b.add(tmp);
      }
    }));
    for (Integer z : b) {
      System.out.print(z + " ");
    }
  }
}
