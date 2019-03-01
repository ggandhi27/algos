package algorithms.hackerearth.januarycircuits2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

public class Question4 {

  static List<Long> list;
  static HashMap<Long, Pair<Long, Integer>> map;

  static long[] findKMax(int size, List<Long> list) {
    map = new HashMap<>();
    long max = 0;
    long k = 0;
    long runningMax = list.stream().reduce(Long::max).get();
    for (Long l : list) {
      for (long i = runningMax; i >= 1; i--) {
        if (l.equals(i)) {
          map.put(l, new Pair<>(l, 1));
          if (l > max) {
            max = l;
            k = 1;
          }
        } else if (map.containsKey(i - l)) {
          Pair<Long, Integer> pair = map.get(i - l);
          Pair<Long, Integer> existing = map.get(i);
          long temp = i / (pair.getValue() + 1);
          if (existing != null) {
            if (existing.getKey() < temp) {
              map.put(i, new Pair<>(temp, pair.getValue() + 1));
              if (temp > max) {
                max = temp;
                k = pair.getValue() + 1;
              }
            } else if (existing.getKey() == temp && existing.getValue() < pair.getValue() + 1) {
              map.put(i, new Pair<>(temp, pair.getValue() + 1));
              if (temp > max) {
                max = temp;
                k = pair.getValue() + 1;
              }
            }
          } else {
            map.put(i, new Pair<>(temp, pair.getValue() + 1));
            if (temp > max) {
              max = temp;
              k = pair.getValue() + 1;
            }
          }
        }
      }
    }
    k = list.contains(0L) ? k + size : k;
    return new long[]{max, k};
  }

  static void maxSubArraySum(int a[], int start, int end, List<Long> list) {
    long[] sem = doSomething(a, start, end);
    if (sem[2] >= 0) {
      list.add(sem[2]);
      doSomething(a, start, (int) sem[0] - 1);
      doSomething(a, (int) sem[1] + 1, end);
    }
  }


  static long[] doSomething(int a[], int x, int y) {
    long max_so_far = Long.MIN_VALUE, max_ending_here = 0, start = x, end = x, s = x;
    for (int i = x; i <= y; i++) {
      max_ending_here += a[i];
      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
        start = s;
        end = i;
      }
      if (max_ending_here < 0) {
        max_ending_here = 0;
        s = i + 1;
      }
    }
    return new long[]{start, end, max_so_far};
  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int no = Integer.parseInt(br.readLine());
    int[] nos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    list = new LinkedList<>();
    maxSubArraySum(nos, 0, no - 1, list);
    long[] res = findKMax(no, list);
    System.out.println(res[0] + " " + res[1]);
  }

}
