package multithreading;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Stock2 {

  int produced = 0;
  int consumed = 0;
  ReentrantLock reentrantLock;

  public Stock2(ReentrantLock reentrantLock) {
    this.reentrantLock = reentrantLock;
  }

  public void addToStock() {
    try {
      reentrantLock.lock();
      if (produced <= consumed + 10) {
        produced++;
        System.out.println(Thread.currentThread().getName() + " -> Produced : " + produced);
      }
    } finally {
      reentrantLock.unlock();
    }
  }

  public void consumeFromStock() {
    try {
      reentrantLock.lock();
      if (consumed < produced) {
        consumed++;
        System.out.println(Thread.currentThread().getName() + " -> Consumed : " + consumed);
      }
    } finally {
      reentrantLock.unlock();
    }
  }
}

public class MyExecutor {

  public static void main(String[] args) {
    ReentrantLock reentrantLock = new ReentrantLock(true);
    Stock2 stock2 = new Stock2(reentrantLock);
    Random random = new Random();
    Executor executor = Executors.newFixedThreadPool(3);
    executor.execute(() -> {
      while (true) {
        stock2.addToStock();
        try {
          Thread.sleep(random.nextInt(2000));
        } catch (Exception exp) {

        }
      }
    });
    executor.execute(() -> {
      while (true) {
        stock2.consumeFromStock();
        try {
          Thread.sleep(random.nextInt(2000));
        } catch (Exception exp) {

        }
      }
    });
    executor.execute(() -> {
      while (true) {
        stock2.consumeFromStock();
        try {
          Thread.sleep(random.nextInt(2000));
        } catch (Exception exp) {

        }
      }
    });

    ((ExecutorService) executor).shutdown();
  }
}
