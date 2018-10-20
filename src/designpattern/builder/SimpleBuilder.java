package designpattern.builder;

class Emp {

  private String name;
  private String designation;

  public void setName(String name) {
    this.name = name;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  @Override
  public String toString() {
    return "Emp{" +
        "name='" + name + '\'' +
        ", designation='" + designation + '\'' +
        '}';
  }
}

class EmpBuilder {

  private Emp emp = new Emp();

  public Emp build(String name, String designation) {
    emp.setName(name);
    emp.setDesignation(designation);
    return emp;
  }
}

public class SimpleBuilder {

  public static void main(String[] args) {
    EmpBuilder builder = new EmpBuilder();
    System.out.println(builder.build("Abhishek", "SSE").toString());
  }
}
