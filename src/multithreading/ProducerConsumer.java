package multithreading;

import java.util.Random;

class Stock {
  int stockNumber = 0;
  int consumed = 0;

  public synchronized void consume() {
    while (stockNumber == consumed) {
      try {
        wait();
      } catch (Exception exp) {

      }
    }
    consumed++;
    System.out.println("Stock no. " + consumed + " consumed.");
    notifyAll();
  }

  public synchronized void produce() {
    while (stockNumber > consumed) {
      try {
        wait();
      } catch (Exception exp) {

      }
    }
    stockNumber++;
    System.out.println("Stock no. " + stockNumber + " produced.");
    notifyAll();
  }
}

class Producer implements Runnable {

  private Stock stock;

  public Producer(Stock stock) {
    this.stock = stock;
  }

  @Override
  public void run() {
    Random random = new Random();
    while (true) {
      stock.produce();
      try {
        Thread.sleep(random.nextInt(2000));
      } catch (Exception exp) {

      }
    }
  }
}

class Consumer implements Runnable {

  private Stock stock;

  public Consumer(Stock stock) {
    this.stock = stock;
  }

  @Override
  public void run() {
    Random random = new Random();
    while (true) {
      stock.consume();
      try {
        Thread.sleep(random.nextInt(2000));
      } catch (Exception exp) {

      }
    }
  }
}

public class ProducerConsumer {

  public static void main(String[] args) {
    Stock stock = new Stock();
    new Thread(new Producer(stock)).start();
    new Thread(new Consumer(stock)).start();
  }

}
