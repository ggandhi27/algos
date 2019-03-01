package multithreading;

import java.util.concurrent.locks.ReentrantLock;

class Resource {

  int i;

  public Resource(int i) {
    this.i = i;
  }

  public void print() {
    System.out.println(i + " ");
    i++;
  }
}

class Odd implements Runnable {

  Resource resource;
  ReentrantLock reentrantLock;

  public Odd(Resource resource, ReentrantLock reentrantLock) {
    this.resource = resource;
    this.reentrantLock = reentrantLock;
  }

  public void print() throws InterruptedException {
    reentrantLock.lock();
    if (resource.i % 2 != 0) {
      resource.print();
      Thread.sleep(1000);
    }
    reentrantLock.unlock();
  }

  @Override
  public void run() {
    while (true) {
      try {
        print();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Even implements Runnable {

  Resource resource;
  ReentrantLock reentrantLock;

  public Even(Resource resource, ReentrantLock reentrantLock) {
    this.resource = resource;
    this.reentrantLock = reentrantLock;
  }

  public void print() throws InterruptedException {
    reentrantLock.lock();
    if (resource.i % 2 == 0) {
      resource.print();
      Thread.sleep(1000);
    }
    reentrantLock.unlock();
  }

  @Override
  public void run() {
    while (true) {
      try {
        print();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class ProducerConsumerReentrant {

  public static void main(String[] args) {

    Resource resource = new Resource(0);
    ReentrantLock lock = new ReentrantLock();
    Thread threadOdd = new Thread(new Odd(resource, lock));
    Thread threadEven = new Thread(new Even(resource, lock));
    threadOdd.start();
    threadEven.start();
  }
}
