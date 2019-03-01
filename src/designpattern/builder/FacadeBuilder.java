package designpattern.builder;

class Address3 {

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
}

class Emp3 {

  private String name;
  private String designation;
  private Address3 address3;

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

  public Address3 getAddress3() {
    return address3;
  }

  public void setAddress3(Address3 address3) {
    this.address3 = address3;
  }
}

class EmpBuilder3 {

  private Emp3 emp3 = new Emp3();
  private AddressBuilder addressBuilder = new AddressBuilder();

  public EmpBuilder3 withName(String name) {
    emp3.setName(name);
    return this;
  }

  public EmpBuilder3 withDesignation(String designation) {
    emp3.setDesignation(designation);
    return this;
  }

  public AddressBuilder lives() {
    return addressBuilder;
  }

  public Emp3 build() {
    return emp3;
  }
}

class AddressBuilder extends EmpBuilder3 {

  private Address3 address3 = new Address3();

  public AddressBuilder atHouse(String house) {
    address3.setHouse(house);
    return this;
  }

  public AddressBuilder inCity(String city) {
    address3.setCity(city);
    return this;
  }

  public AddressBuilder atCode(Integer pincode) {
    address3.setPincode(pincode);
    return this;
  }
}

public class FacadeBuilder {

  public static void main(String[] args) {
    EmpBuilder3 empBuilder3 = new EmpBuilder3();
    empBuilder3
        .lives()
        .atCode(110091)
        .atHouse("260")
        .inCity("Delhi")
        .withDesignation("SSE")
        .withName("Abhishek");

  }
}
