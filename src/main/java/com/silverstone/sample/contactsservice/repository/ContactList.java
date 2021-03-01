package com.silverstone.sample.contactsservice.repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ContactList implements Serializable {

    private Name name;
    private String phone;

    public ContactList(Name name,String phone) {

        this.name = name;
        this.phone = phone;

    }
}
