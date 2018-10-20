package algorithms.list;

class Node<T> {

  private T data;
  private Node<T> next;

  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

}

public class SinglyLinkListReverse {

  public static void main(String[] args) {
    Node<Integer> start = new Node<>(1, null);
    Node<Integer> current = start;
    for (int i = 2; i < 10; i++) {
      Node<Integer> newNode = new Node<>(i, null);
      current.setNext(newNode);
      current = newNode;
    }

    Node<Integer> itr = start;
    while (itr != null) {
      System.out.println(itr.getData());
      itr = itr.getNext();
    }

    Node<Integer> next = null;
    Node<Integer> previous = null;
    itr = start;
    while (itr != null) {
      next = itr.getNext();
      itr.setNext(previous);
      previous = itr;
      itr = next;
    }

    itr = previous;
    while (itr != null) {
      System.out.println(itr.getData());
      itr = itr.getNext();
    }
  }

}
