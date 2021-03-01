package com.silverstone.sample.contactsservice.repository;

import com.silverstone.sample.contactsservice.model.ContactPerson;

import java.util.List;

public interface ContactHomeType {

    ContactPersonView getName();
    List<PhoneView> getPhone();
    interface PhoneView {
        String getNumber();
        String getType();


    }
    interface ContactPersonView {
        String getFirstName();
        String getLastName();
        String getMiddleName();
    }
}
