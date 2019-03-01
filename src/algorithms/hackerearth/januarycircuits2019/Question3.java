package algorithms.hackerearth.januarycircuits2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Question3 {

  public static Map<Character, Integer> map = new HashMap<>();
  public static Map<Integer, List<Integer>> subscripts = new TreeMap<>(Collections.reverseOrder());

  public static void initMap() {
    map.put('a', 26);
    map.put('b', 25);
    map.put('c', 24);
    map.put('d', 23);
    map.put('e', 22);
    map.put('f', 21);
    map.put('g', 20);
    map.put('h', 19);
    map.put('i', 18);
    map.put('j', 17);
    map.put('k', 16);
    map.put('l', 15);
    map.put('m', 14);
    map.put('n', 13);
    map.put('o', 12);
    map.put('p', 11);
    map.put('q', 10);
    map.put('r', 9);
    map.put('s', 8);
    map.put('t', 7);
    map.put('u', 6);
    map.put('v', 5);
    map.put('w', 4);
    map.put('x', 3);
    map.put('y', 2);
    map.put('z', 1);
    for (int i = 25; i > 0; i++) {
      subscripts.put(i, new ArrayList<>());
    }
  }

//  public static int[] subscripts(int k) {
//    int i=0;
//    ArrayList<Integer> s = new ArrayList<>(k);
//    for(Map.Entry<Integer, List<Integer>> entry:subscripts.entrySet()) {
//      for(Integer x:entry.getValue()) {
//        s.add(x);
//        ++i;
//        if(i==k) {
//          return s;
//        }
//      }
//    }
//  }
  
  public static int minOps(char[] c, int k) {
    int[] weights = new int[c.length];
    weights[0] = 0;
    for (int i = 1; i < c.length; i++) {
      int x = map.get(c[i]) - map.get(c[i - 1]);
      weights[i] = x >= 0 ? x : 26 - x;
      subscripts.get(weights[i]).add(i);
    }
    return 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] c = br.readLine().toCharArray();
    int k = Integer.parseInt(br.readLine());
  }
}
