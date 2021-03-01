package com.silverstone.sample.contactsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@JsonPropertyOrder({"id","name","address","phone","email"})
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("name")
    @Embedded
    ContactPerson name;

    @Embedded
    Address address;

//    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    List<Phone> phone = new ArrayList<>();

    private String email;

    public Contact() {

    }

    public Contact(ContactPerson name, Address address, List<Phone> phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
