package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class Producer2 implements Runnable {

  List<Integer> buffer;
  ReentrantLock reentrantLock;

  public Producer2(List<Integer> buffer, ReentrantLock reentrantLock) {
    this.buffer = buffer;
    this.reentrantLock = reentrantLock;
  }

  @Override
  public void run() {
    try {
      while (true) {
        try {
          reentrantLock.lock();
          if (buffer.size() >= 0 && buffer.size() < 10) {
            buffer.add(1);
            System.out.println(Thread.currentThread().getName() + " : " + buffer.size());
          }
        } finally {
          reentrantLock.unlock();
        }
      }
    } catch (Exception exp) {

    }
  }
}

class Consumer2 implements Runnable {

  List<Integer> buffer;
  ReentrantLock reentrantLock;

  public Consumer2(List<Integer> buffer, ReentrantLock reentrantLock) {
    this.buffer = buffer;
    this.reentrantLock = reentrantLock;
  }

  @Override
  public void run() {
    try {
      while (true) {
        try {
          reentrantLock.lock();
          if (buffer.size() > 0) {
            buffer.remove(0);
            System.out.println(Thread.currentThread().getName() + " : " + buffer.size());
          }
        } finally {
          reentrantLock.unlock();
        }
      }
    } catch (Exception exp) {

    }
  }
}

public class ReLock {

  public static void main(String[] args) {
    ReentrantLock reentrantLock = new ReentrantLock(true);
    List<Integer> list = new ArrayList<>(10);
    new Thread(new Consumer2(list, reentrantLock)).start();
    new Thread(new Producer2(list, reentrantLock)).start();
    new Thread(new Consumer2(list, reentrantLock)).start();

  }
}
