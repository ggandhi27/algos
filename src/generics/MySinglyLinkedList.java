package generics;

class Node<T extends Number> {
  private T data;
  private Node<T> next;

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

class SinglyList<T extends Number> {

  private Node<T> head;
  private Node<T> tail;

  public void add(T value) {
    if (head == null) {
      head = new Node<>();
      head.setData(value);
      tail = head;
    } else {
      Node<T> newNode = new Node<>();
      newNode.setData(value);
      tail.setNext(newNode);
      tail = newNode;
    }
  }

  public void delete(T value) {
    if (head != null) {
      Node<T> previous = null;
      Node<T> currentNode = head;
      while (currentNode != null) {
        if (currentNode.getData().equals(value)) {
          if (previous != null) {
            previous.setNext(currentNode.getNext());
          } else {
            head = head.getNext();
          }
        } else {
          previous = currentNode;
        }
        currentNode = currentNode.getNext();
      }
    }
  }

  public void print() {
    Node<T> ptr = head;
    while (ptr != null) {
      System.out.print(ptr.getData() + " ");
      ptr = ptr.getNext();
    }
  }
}

public class MySinglyLinkedList {
  public static void main(String[] args) {
    SinglyList<Integer> list = new SinglyList<>();
    list.add(5);
    list.add(4);
    list.add(4);
    list.add(5);
    list.add(4);
    list.delete(4);
    list.print();
  }
}
