package algorithms.hackerearth.septembereasy2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");

    long cor = Long.parseLong(inputs[1]);
    long cod = Long.parseLong(inputs[2]);

    List<Long> values = Arrays.stream(br.readLine().split(" "))
        .map(Long::parseLong).sorted()
        .collect(Collectors.toList());
    long cost = 0;
    Set<Long> existing = new HashSet<>();
    for (Long value : values) {
      if (existing.contains(value)) {
        long tcod = cod;
        for (long i = value - 1; tcod < cor; i--) {
          if (!existing.contains(i)) {
            existing.add(i);
            cost += tcod;
            break;
          } else {
            tcod += cod;
          }
        }
        if (tcod >= cor) {
          cost += cor;
        }
      } else {
        existing.add(value);
      }
    }
    System.out.println(cost);
  }

}
