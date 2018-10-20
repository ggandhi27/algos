package designpattern.prototype;

import org.apache.commons.lang3.SerializationUtils;

public class PrototypeSerialization {

  public static void main(String[] args) {
    Prototype1 prototype1 = new Prototype1(23, new Composite1(34,43));
    System.out.println(prototype1.toString());
    Prototype1 prototype2 = SerializationUtils.clone(prototype1);
    prototype2.getComposite().setDogma(29);
    System.out.println(prototype1.toString());
    System.out.println(prototype2.toString());
  }
}
