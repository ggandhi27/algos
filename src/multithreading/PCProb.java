package multithreading;

class Stock1 {

  private int produced = 0;
  private int consumed = 0;

  public synchronized void increaseStock() throws InterruptedException {
    while (produced > consumed) {
      wait();
    }
    System.out.println("Produced " + ++produced);
    notifyAll();
  }

  public synchronized void decreaseStock() throws InterruptedException {
    while (consumed == produced) {
      wait();
    }
    System.out.println("Consumed " + ++consumed);
    notifyAll();
  }
}

class Producer1 implements Runnable {

  Stock1 stock;

  public Producer1(Stock1 stock) {
    this.stock = stock;
  }

  @Override
  public void run() {
    while (true) {
      try {
        stock.increaseStock();
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Consumer1 implements Runnable {

  Stock1 stock;

  public Consumer1(Stock1 stock) {
    this.stock = stock;
  }

  @Override
  public void run() {
    while (true) {
      try {
        stock.decreaseStock();
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class PCProb {

  public static void main(String[] args) {
    Stock1 stock = new Stock1();
    Producer1 producer1 = new Producer1(stock);
    Consumer1 consumer1 = new Consumer1(stock);

    Thread thread = new Thread(producer1);
    Thread thread1 = new Thread(consumer1);

    thread.start();
    thread1.start();
  }
}
