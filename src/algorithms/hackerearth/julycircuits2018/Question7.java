package algorithms.hackerearth.julycircuits2018;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Question7 {

  private static void addValue(Map<String, Set<String>> tree, String vertex1, String vertex2) {
    if (tree.containsKey(vertex1)) {
      tree.get(vertex1).add(vertex2);
    } else {
      tree.put(vertex1, new HashSet<>(Collections.singletonList(vertex2)));
    }
  }

  private static void createTree(int noOfVertices, Map<String, Set<String>> tree, BufferedReader br) throws Exception {
    for (int i = 1; i < noOfVertices; i++) {
      String[] edge = br.readLine().split(" ");
      addValue(tree, edge[0], edge[1]);
      addValue(tree, edge[1], edge[0]);
    }
  }

  private static Map<Integer, Integer> prepareCostGraph(String startingNode, Map<String, Set<String>> tree) {
    Map<Integer, Integer> weightAtEachLevel = new HashMap<>();
    LinkedList<Pair<String, Integer>> valueAtLevel = new LinkedList<>();
    valueAtLevel.add(new Pair<>(startingNode, 0));
    HashSet<String> alreadyVisitedNodes = new HashSet<>();
    while (!valueAtLevel.isEmpty()) {
      Pair<String, Integer> pair = valueAtLevel.getFirst();
      Integer level = pair.getValue() + 1;
      tree.get(pair.getKey()).stream()
          .filter(node -> !alreadyVisitedNodes.contains(node)).collect(Collectors.toSet())
          .forEach(node -> {
            valueAtLevel.add(new Pair<>(node, level));
            if (weightAtEachLevel.containsKey(level)) {
              weightAtEachLevel.put(level, weightAtEachLevel.get(level) + 1);
            } else {
              weightAtEachLevel.put(level, 1);
            }
          });
      valueAtLevel.remove(0);
      alreadyVisitedNodes.add(pair.getKey());
    }
    return weightAtEachLevel;
  }

  private static void calculateCost(int noOfVerticesInTree1, int noOfVerticesInTree2, Map<String, Set<String>> tree1,
                                    Map<String, Set<String>> tree2) {
    Map<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> map2 = new HashMap<>();
    for (Integer i = 1; i <= noOfVerticesInTree1; i++) {
      map1.put(i, prepareCostGraph(i.toString(), tree1));
    }
    for (Integer i = 1; i <= noOfVerticesInTree2; i++) {
      map2.put(i, prepareCostGraph(i.toString(), tree2));
    }
    for (Integer i = 1; i <= noOfVerticesInTree1; i++) {
      Map<Integer, Integer> costMap1 = map1.get(i);
      for (Integer j = 1; j <= noOfVerticesInTree2; j++) {
        int cost = 0;
        Map<Integer, Integer> costMap2 = map2.get(j);
        int k = noOfVerticesInTree1 > noOfVerticesInTree2 ? noOfVerticesInTree1 : noOfVerticesInTree2;
        for (; k > 0; k--) {
          cost += Math.abs(costMap2.getOrDefault(k, 0) - costMap1.getOrDefault(k, 0));
        }
        System.out.print(cost + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] noOfVertices = br.readLine().split(" ");
    int noOfVerticesInTree1 = Integer.parseInt(noOfVertices[0]);
    int noOfVerticesInTree2 = Integer.parseInt(noOfVertices[1]);
    Map<String, Set<String>> tree1 = new HashMap<>();
    Map<String, Set<String>> tree2 = new HashMap<>();
    createTree(noOfVerticesInTree1, tree1, br);
    createTree(noOfVerticesInTree2, tree2, br);
    calculateCost(noOfVerticesInTree1, noOfVerticesInTree2, tree1, tree2);
  }
}
