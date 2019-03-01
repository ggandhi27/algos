package designpattern.builder;

class Emp2 {

  private String name;
  private String desgination;

  public void setName(String name) {
    this.name = name;
  }

  public void setDesgination(String desgination) {
    this.desgination = desgination;
  }

  @Override
  public String toString() {
    return "Emp2{" +
        "name='" + name + '\'' +
        ", desgination='" + desgination + '\'' +
        '}';
  }
}

class EmpBuilder2 {

  private Emp2 emp2 = new Emp2();

  public EmpBuilder2 withName(String name) {
    emp2.setName(name);
    return this;
  }

  public EmpBuilder2 withDesignation(String designation) {
    emp2.setDesgination(designation);
    return this;
  }

  public Emp2 build() {
    return emp2;
  }
}

public class FluentBuilder {

  public static void main(String[] args) {
    EmpBuilder2 builder2 = new EmpBuilder2();
    System.out.println(builder2
        .withName("Abhishek")
        .withDesignation("SSE")
        .build().toString());
  }
}
