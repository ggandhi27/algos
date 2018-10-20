package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Modes {

  String revIt();

  void Ecomony();
}

class Car3 implements Modes {

  private String name;
  private String bhp;

  public Car3(String name, String bhp) {
    this.name = name;
    this.bhp = bhp;
  }

  public String revIt() {
    System.out.println("Race mode on full bhp: " + bhp);
    return "BOOM";
  }

  public void Ecomony() {
    System.out.println("Chill mode on");
  }
}

class DynamicProxyHelper implements InvocationHandler {

  private Object target;

  public DynamicProxyHelper(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.getName().equals("Economy")) {
      System.out.println("Good user");
    } else {
      System.out.println("Bad user");
    }
    return method.invoke(target, args);
  }
}

public class DynamicProxyDemo {

  public static void main(String[] args) {
    Modes car3 = new Car3("COROLLA", "200");
    Modes proxyInstance = (Modes) Proxy
        .newProxyInstance(Modes.class.getClassLoader(), new Class<?>[]{Modes.class},
            new DynamicProxyHelper(car3));
    proxyInstance.revIt();
    proxyInstance.Ecomony();
    proxyInstance.revIt();
  }

}
