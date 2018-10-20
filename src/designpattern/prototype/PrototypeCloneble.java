package designpattern.prototype;

// Cloneable sucks as it creates shallow copy
class Composite implements Cloneable {

  private Integer dogma;
  private Integer karuma;

  public Composite(Integer dogma, Integer karuma) {
    this.dogma = dogma;
    this.karuma = karuma;
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

class Prototype implements Cloneable {

  private Integer data;
  private Composite composite;

  public Prototype(Integer data, Composite composite) {
    this.data = data;
    this.composite = composite;
  }

  public Integer getData() {
    return data;
  }

  public void setData(Integer data) {
    this.data = data;
  }

  public Composite getComposite() {
    return composite;
  }

  public void setComposite(Composite composite) {
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

public class PrototypeCloneble {

  public static void main(String[] args) throws Exception {
    Prototype prototype1 = new Prototype(23, new Composite(23, 12));
    System.out.println(prototype1.toString());
    Prototype prototype2 = prototype1.clone();
    prototype2.setData(45);
    prototype2.getComposite().setDogma(76);
    System.out.println(prototype1.toString());
    System.out.println(prototype2.toString());
  }
}


