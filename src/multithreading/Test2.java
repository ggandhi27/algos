package multithreading;

class Th implements Runnable {

  String msg;

  public Th(String msg) {
    this.msg = msg;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(msg);
  }

}

public class Test2 {

  public static void main(String[] args) throws Exception {
    Thread thread1 = new Thread(new Th("this is the 1st thread"));
    Thread thread2 = new Thread(new Th("this is the 2nd thread"));
    thread1.start();
    thread2.start();
    thread1.join(1000);
  }
}
