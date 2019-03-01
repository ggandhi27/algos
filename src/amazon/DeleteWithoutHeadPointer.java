package amazon;

/**
 * Actual node is never deleted, data from next node is copied to this node and hence so on and then
 * last node is deleted. The question will never deal with deleting the last node as it can't be
 * done.
 */
class Node1 {

  int data;
  Node1 next;

  Node1(int d) {
    data = d;
    next = null;
  }
}

public class DeleteWithoutHeadPointer {

  public static void del(Node1 del) {
    while (del.next.next != null) {
      del.data = del.next.data;
      del = del.next;
    }
    del.data = del.next.data;
    del.next = null;
  }


  public static void main(String[] args) throws Exception {
    Node1 head = new Node1(1);
    Node1 node2 = new Node1(2);
    head.next = node2;
    Node1 node3 = new Node1(3);
    node2.next = node3;
    Node1 node4 = new Node1(4);
    node3.next = node4;
    Node1 node5 = new Node1(5);
    node4.next = node5;
    del(node3);
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }
}
