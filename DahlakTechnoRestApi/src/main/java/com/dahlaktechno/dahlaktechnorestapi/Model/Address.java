package com.dahlaktechno.dahlaktechnorestapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String  street;
    private String city;
    private String state;
    private Integer zipCode;
    private String country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutorial_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee anEmployee ;

    public Address(Integer addressId, String street, String city, String state, Integer zipCode, String country, Employee anEmployee) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.anEmployee = anEmployee;
    }

    public Address() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getAddressId().equals(address.getAddressId()) && getStreet().equals(address.getStreet()) && getCity().equals(address.getCity()) && getState().equals(address.getState()) && getZipCode().equals(address.getZipCode()) && getCountry().equals(address.getCountry()) && getAnEmployee().equals(address.getAnEmployee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId(), getStreet(), getCity(), getState(), getZipCode(), getCountry(), getAnEmployee());
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getAnEmployee() {
        return anEmployee;
    }

    public void setAnEmployee(Employee anEmployee) {
        this.anEmployee = anEmployee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", country='" + country + '\'' +
                ", anEmployee=" + anEmployee +
                '}';
    }
}
