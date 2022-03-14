package jSearch.models;

public class Address {
    String street_address;
    String postal_code;
    String city;
    String region;
    String country;

    public Address(String street_address, String postal_code, String city, String region, String country) {
        this.street_address = street_address;
        this.postal_code = postal_code;
        this.city = city;
        this.region = region;
        this.country = country;
    }
}
