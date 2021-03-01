package com.silverstone.sample.contactsservice.service;

import com.silverstone.sample.contactsservice.model.Contact;
import com.silverstone.sample.contactsservice.model.PhoneType;
import com.silverstone.sample.contactsservice.repository.ContactHomeType;
import com.silverstone.sample.contactsservice.repository.ContactList;
import com.silverstone.sample.contactsservice.repository.ContactsRepository;
import com.silverstone.sample.contactsservice.repository.Name;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements  ContactService{

    private ContactsRepository contactsRepository;

    public ContactServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public Iterable<Contact> list() {
        return contactsRepository.findAll();
    }

    @Override
    public Contact save(Contact contact) {
        return contactsRepository.save(contact);
    }

    @Override
    public Iterable<Contact> save(List<Contact> contactList) {
        return contactsRepository.saveAll(contactList);
    }

    @Override
    public Optional<Contact> getContact(Long id) {
        return contactsRepository.findById(id);
    }

    @Override
    public void deleteContact(Long id) {
          contactsRepository.deleteById(id);
    }

    @Override
    public Optional<Contact> updateContact(Contact updated, Long id) {
       return contactsRepository.findById(id).map(contact -> {
            contact.setName(updated.getName());
            contact.setAddress(updated.getAddress());
            contact.setEmail(updated.getEmail());
            contact.setPhone(updated.getPhone());
           return contactsRepository.save(contact);
       });

    }
    @Override
    public List<ContactList> callList() {

        List<ContactList> contactLists =new ArrayList<>();
       // Need to remodel it and filter it at JPA query for better performance.
       // One approach is to have this business logic in Service class to return the required response.
       // JPA Filter on embedabble collection
       List<ContactHomeType> contactHomeTypes = contactsRepository.findContactByPhone_Type(PhoneType.home);
        contactHomeTypes.forEach(c-> {

            List<ContactHomeType.PhoneView> phones = c.getPhone();
            phones.removeIf(p->!p.getType().equals("home"));
            Name name = new Name(c.getName().getFirstName(),c.getName().getMiddleName(),c.getName().getLastName());
            contactLists.add(new ContactList(name,phones.get(0).getNumber()));

        });

        return contactLists;
    }
}
