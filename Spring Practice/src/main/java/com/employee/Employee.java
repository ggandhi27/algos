package com.employee;

public class Employee {
    int id;
    String name;
    Address address;
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
    
    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public Employee(Address address) {
        this.address = address;
    }
    
    Employee() {
        System.out.println("def cons");
    }
    
    Employee(int id) {
        this.id = id;
    }
    
    Employee(String name){
        this.name = name;
    }
    
    Employee(int id,String name){
        this.name = name;
        this.id = id;
    }
    
}
