package com.silverstone.sample.contactsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {

    }
}
