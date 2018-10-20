package designpattern.solid.builder;

class Address4 {

  private String house;
  private String city;
  private Integer pincode;

  public void setHouse(String house) {
    this.house = house;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setPincode(Integer pincode) {
    this.pincode = pincode;
  }

  @Override
  public String toString() {
    return "Address4{" +
        "house='" + house + '\'' +
        ", city='" + city + '\'' +
        ", pincode=" + pincode +
        '}';
  }
}

class Emp4 {

  private String name;
  private String designation;
  private Address4 address4;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public Address4 getAddress4() {
    return address4;
  }

  public void setAddress4(Address4 address4) {
    this.address4 = address4;
  }

  @Override
  public String toString() {
    return "Emp4{" +
        "name='" + name + '\'' +
        ", designation='" + designation + '\'' +
        ", address4=" + address4 +
        '}';
  }
}

class PersonBuilder<T extends PersonBuilder<T>> {

  protected Emp4 emp4 = new Emp4();

  public T withName(String name) {
    emp4.setName(name);
    return (T) this;
  }

  public T withDesignation(String designation) {
    emp4.setDesignation(designation);
    return (T) this;
  }

  public Emp4 build() {
    return emp4;
  }
}

class EmpBuilder4 extends PersonBuilder<EmpBuilder4> {

  protected Address4 address4 = new Address4();

  public EmpBuilder4 lives() {
    emp4.setAddress4(address4);
    return this;
  }

  public EmpBuilder4 atHouse(String house) {
    address4.setHouse(house);
    return this;
  }

  public EmpBuilder4 inCity(String city) {
    address4.setCity(city);
    return this;
  }

  public EmpBuilder4 atCode(Integer pincode) {
    address4.setPincode(pincode);
    return this;
  }

}

public class FluentBuilderWithInheritance {

  public static void main(String[] args) {
    EmpBuilder4 personBuilder = new EmpBuilder4();
    System.out.println(personBuilder
        .withName("Abhishek")
        .withDesignation("SSE")
        .lives()
        .atCode(110091)
        .atHouse("260")
        .inCity("Delhi").build().toString());
  }

}
