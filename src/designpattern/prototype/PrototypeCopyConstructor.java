package designpattern.prototype;

import java.io.Serializable;

// Copy constructors are better than cloneable.
class Composite1 implements Cloneable, Serializable {

  private Integer dogma;
  private Integer karuma;

  public Composite1(Integer dogma, Integer karuma) {
    this.dogma = dogma;
    this.karuma = karuma;
  }

  public Composite1(Composite1 composite1) {
    this(composite1.dogma, composite1.karuma);
  }

  public Integer getDogma() {
    return dogma;
  }

  public void setDogma(Integer dogma) {
    this.dogma = dogma;
  }

  public Integer getKaruma() {
    return karuma;
  }

  public void setKaruma(Integer karuma) {
    this.karuma = karuma;
  }

  @Override
  public String toString() {
    return "Composite{" +
        "dogma=" + dogma +
        ", karuma=" + karuma +
        '}';
  }
}

class Prototype1 implements Cloneable, Serializable {

  private Integer data;
  private Composite1 composite;


  public Prototype1(Integer data, Composite1 composite) {
    this.data = data;
    this.composite = composite;
  }

  public Prototype1(Prototype1 prototype1) {
    this.data = prototype1.data;
    this.composite = new Composite1(prototype1.composite);
  }

  public Integer getData() {
    return data;
  }

  public void setData(Integer data) {
    this.data = data;
  }

  public Composite1 getComposite() {
    return composite;
  }

  public void setComposite1(Composite1 composite) {
    this.composite = composite;
  }

  @Override
  public Prototype clone() throws CloneNotSupportedException {
    return (Prototype) super.clone();
  }

  @Override
  public String toString() {
    return "prototype{" +
        "data=" + data +
        ", composite=" + composite +
        '}';
  }
}

public class PrototypeCopyConstructor {

  public static void main(String[] args) {
    Prototype1 prototype1 = new Prototype1(23, new Composite1(23, 12));
    System.out.println(prototype1.toString());
    Prototype1 prototype2 = new Prototype1(prototype1);
    prototype2.setData(45);
    prototype2.getComposite().setDogma(76);
    System.out.println(prototype1.toString());
    System.out.println(prototype2.toString());
  }
}
