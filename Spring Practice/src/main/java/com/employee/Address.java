package com.employee;

public class Address {
    private String city;
    private String country;
    private String landmark;
    
    public Address(String city, String country, String landmark) {
        this.city = city;
        this.country = country;
        this.landmark = landmark;
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", landmark='" + landmark + '\'' +
                '}';
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getLandmark() {
        return landmark;
    }
    
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
