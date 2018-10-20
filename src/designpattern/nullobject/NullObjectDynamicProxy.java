package designpattern.nullobject;

import java.lang.reflect.Proxy;

interface EngineFunctionality {

  void startEngine();

  String changeMode(String mode);
}

class Engine implements EngineFunctionality {

  private String currentMode;
  private boolean engineOn;

  @Override
  public void startEngine() {
    if (engineOn) {
      System.out.println("Engine already up");
    } else {
      System.out.println("Starting the engine");
    }
  }

  @Override
  public String changeMode(String mode) {
    currentMode = mode;
    System.out.println("Current mode is " + mode);
    return mode;
  }
}

class Car {

  private EngineFunctionality engine;

  public Car(EngineFunctionality engine) {
    this.engine = engine;
  }

  public void getCarReady() {
    engine.startEngine();
    engine.changeMode("ECONOMY");
  }
}

public class NullObjectDynamicProxy {

  public static void main(String[] args) {
    EngineFunctionality proxy = (EngineFunctionality)
        Proxy.newProxyInstance(EngineFunctionality.class.getClassLoader(),
            new Class<?>[]{EngineFunctionality.class}, (proxy1, method, args1) -> {
              if (method.getReturnType() == Void.TYPE) {
                return null;
              } else {
                return method.getReturnType().newInstance();
              }
            });
    Car car = new Car(proxy);
    car.getCarReady();
  }
}