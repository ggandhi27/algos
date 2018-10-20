package multithreading;

class Th2 extends Thread {

  @Override
  public void run() {
    System.out.println("Thread is running by class");
  }

}

class Th1 implements Runnable {

  @Override
  public void run() {
    System.out.println("Thread is running by runnable");
  }

}

public class Test1 {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName());
    Thread thread1 = new Thread(new Th1());
    thread1.run();
    Thread thread2 = new Thread(new Th2());
    thread2.run();
    Thread thread3 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Thread by anonymous class");
      }
    });
    thread3.run();
    Thread thread4 = new Thread(() -> System.out.println("Thread by lambda"));
    thread4.run();
  }

}
