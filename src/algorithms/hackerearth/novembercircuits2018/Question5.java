package algorithms.hackerearth.novembercircuits2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question5 {

  public static void main(String[] args) throws Exception {

    class Node {

      String color;
      Node previousNode;
      Node nextNode;
    }

    Node end = null;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    String[] colors = br.readLine().trim().split(" ");

    for (String color : colors) {
      if (end == null) {
        end = new Node();
        end.color = color;
      } else {
        Node newNode = new Node();
        newNode.color = color;
        newNode.previousNode = end;
        end.nextNode = newNode;
        end = newNode;
      }
    }

    int noOfQueries = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < noOfQueries; i++) {
      String[] query = br.readLine().trim().split(" ");
      if (query[0].equals("1")) {
        if (end == null) {
          end = new Node();
          end.color = query[1];
        } else {
          Node newNode = new Node();
          newNode.color = query[1];
          newNode.previousNode = end;
          end.nextNode = newNode;
          end = newNode;
        }
      } else {
        int counter = Integer.parseInt(query[2]);
        int index = 0;
        boolean flag = false;
        Node start = end;
        while (start != null) {
          if (start.color.equals(query[1])) {
            --counter;
            if (counter == 0) {
              System.out.println(index);
              flag = true;
              if (start.previousNode == null && start.nextNode == null) {
                end = null;
              } else {
                if (start.previousNode != null) {
                  start.previousNode.nextNode = start.nextNode;
                }
                if (start.nextNode != null) {
                  start.nextNode.previousNode = start.previousNode;
                }
              }
              break;
            }
          }
          start = start.previousNode;
          ++index;
        }
        if (!flag) {
          System.out.println(-1);
        }
      }
    }
  }
}
