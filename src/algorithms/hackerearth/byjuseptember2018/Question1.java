package algorithms.hackerearth.byjuseptember2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Question1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int noOfStalls = Integer.parseInt(br.readLine());
    long[] values = Arrays.stream(br.readLine()
        .split(" "))
        .mapToLong(Long::parseLong)
        .toArray();
    Arrays.sort(values);
    TreeMap<Long, Integer> map = new TreeMap<>();
    long cumulative = 0;
    int index = 0;
    for (int i = 1; i <= values[noOfStalls - 1]; i++) {
      while (i > values[index]) {
        cumulative += values[index];
        index++;
      }
      map.put((i * (noOfStalls - index)) + cumulative, i);
    }
    int noOfQueries = Integer.parseInt(br.readLine());
    for (int i = 0; i < noOfQueries; i++) {
      Map.Entry<Long, Integer> entry = map.ceilingEntry(Long.parseLong(br.readLine()));
      System.out.println(entry == null ? -1 : entry.getValue());
    }
  }
}
