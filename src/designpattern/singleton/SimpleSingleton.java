package designpattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Singleton implements Serializable {

  private static final Singleton instance = new Singleton();

  private Integer x;

  private Singleton() {
  }

  public static Singleton getInstance() {
    return instance;
  }

  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  protected Object readResolve() {
    return instance;
  }

  @Override
  public String toString() {
    return "Singleton{" +
        "x=" + x +
        '}';
  }
}

public class SimpleSingleton {

  public static byte[] serializer(Singleton singleton) throws Exception {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(singleton);
      return baos.toByteArray();
    }
  }

  public static Singleton deserializer(byte[] object) throws Exception {
    try (ByteArrayInputStream bais = new ByteArrayInputStream(object);
        ObjectInputStream ois = new ObjectInputStream(bais)) {
      return (Singleton) ois.readObject();
    }
  }

  public static void main(String[] args) throws Exception {
    Singleton singleton1 = Singleton.getInstance();
    singleton1.setX(4);
    byte[] serializedObject = serializer(singleton1);
    singleton1.setX(5);
    Singleton singleton2 = deserializer(serializedObject);
    System.out.println(singleton1 == singleton2);
    System.out.println(singleton1);
    System.out.println(singleton2);
  }
}
