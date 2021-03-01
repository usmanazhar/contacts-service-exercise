package com.silverstone.sample.contactsservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Embeddable
public class ContactPerson {

    @JsonProperty("first")
    private String firstName;
    @JsonProperty("middle")
    private String middleName;
    @JsonProperty("last")
    private String lastName;

    public ContactPerson() {

    }
}
