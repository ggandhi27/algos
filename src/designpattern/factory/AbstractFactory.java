package designpattern.factory;

import java.util.HashMap;
import java.util.Map;

interface Factory {

  Drink prepare(Integer amount);
}

class ChaiFactory implements Factory {

  @Override
  public Drink prepare(Integer amount) {
    return new Chai(amount);
  }
}

class CoffeeFactory implements Factory {

  @Override
  public Drink prepare(Integer amount) {
    return new Coffee(amount);
  }
}

class Drink {

  private Integer amount;

  protected Drink(Integer amount) {
    this.amount = amount;
  }
}

class Chai extends Drink {

  public Chai(Integer amount) {
    super(amount);
  }
}

class Coffee extends Drink {

  public Coffee(Integer amount) {
    super(amount);
  }


}

public class AbstractFactory {

  public static void main(String[] args) {
    Map<String, Factory> factories = new HashMap<>();
    factories.put("CHAI", new ChaiFactory());
    factories.put("COFFEE", new CoffeeFactory());

    factories.get("CHAI").prepare(1000);
  }
}
