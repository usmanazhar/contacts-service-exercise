package com.silverstone.sample.contactsservice.service;

import com.silverstone.sample.contactsservice.model.Contact;
import com.silverstone.sample.contactsservice.repository.ContactList;

import java.util.List;
import java.util.Optional;


public interface ContactService {
    Iterable<Contact> list();
    Contact save(Contact contact);
    Iterable<Contact> save(List<Contact> contactList);
    Optional<Contact> getContact(Long id);
    void deleteContact(Long id);
    Optional<Contact> updateContact(Contact updated, Long id);
    List<ContactList> callList();

}
