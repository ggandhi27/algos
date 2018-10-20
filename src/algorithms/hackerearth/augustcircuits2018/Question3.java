package algorithms.hackerearth.augustcircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Question3 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int lengthOfString = Integer.parseInt(br.readLine());
    char[] value = br.readLine().toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < lengthOfString; i++) {
      map.put(value[i], map.getOrDefault(value[i], 0) + 1);
    }
    System.out.println(lengthOfString - map.values().stream().reduce(Integer::max).get());
  }
}
