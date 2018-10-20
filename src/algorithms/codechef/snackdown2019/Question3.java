//package algorithms.codechef.snackdown2019;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class Question3 {
//
//  public static void main(String[] args) throws Exception {
//    HashSet<String> pairs = new HashSet<>();
//    for (int i = 2; i <= 50; i++) {
//      for (int j = i + 1; j <= 50; j++) {
//        if ((new BigInteger(String.valueOf(i)).gcd(new BigInteger(String.valueOf(j))))
//            .equals(BigInteger.ONE)) {
//          pairs.add(i + "," + j);
//          pairs.add(j + "," + i);
//        }
//      }
//    }
//
//    int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int noOfTestCases = Integer.parseInt(br.readLine());
//
//    for (int i = 0; i < noOfTestCases; i++) {
//      br.readLine();
//      List<HashSet<Integer>> subGraphs = new ArrayList<>();
//      ConcurrentHashMap<Integer, List<Integer>> primeHash = new HashMap<>();
//      for (int j = primeNumbers.length - 1; j >= 0; j--) {
//        primeHash.put(primeNumbers[j], new ArrayList<>());
//      }
//      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//      for (int j = 0; j < arr.length; j++) {
//        for (int k = j + 1; k < arr.length; k++) {
//          if (pairs.contains(arr[j] + "," + arr[k])) {
//            boolean flag = false;
//            for (HashSet<Integer> integers : subGraphs) {
//              if (integers.contains(arr[j]) || integers.contains(arr[k])) {
//                integers.add(arr[k]);
//                integers.add(arr[j]);
//                flag = true;
//              }
//            }
//            if (!flag) {
//              HashSet<Integer> temp = new HashSet<>();
//              temp.add(arr[j]);
//              temp.add(arr[k]);
//              subGraphs.add(temp);
//            }a
//          }
//        }
//      }
//
//      if (subGraphs.size() > 1) {
//        for (Map.Entry<Integer, List<Integer>> entry : primeHash.entrySet()) {
//          int x=-1;
//          for (HashSet<Integer> integers : subGraphs) {
//            ++x;
//            if (!integers.contains(entry.getKey())) {
//              entry.getValue().add(x);
//            }
//          }
//        }
//      }
//    }
//  }
//}
