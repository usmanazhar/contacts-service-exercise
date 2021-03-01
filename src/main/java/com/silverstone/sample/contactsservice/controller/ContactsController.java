package com.silverstone.sample.contactsservice.controller;

import com.silverstone.sample.contactsservice.model.Contact;
import com.silverstone.sample.contactsservice.repository.ContactList;
import com.silverstone.sample.contactsservice.service.ContactService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
/****
*  Main Controller class which handles REST Api service end points
*  provide method for
 *   / contacts  - GET,POST,
 *   /contacts/{id} - PUT,DELETE,GET
 *   / contacts/call-lsit - GET
 *   /
*
 * */
@RestController
public class ContactsController {

    private ContactService contactService;

    public ContactsController(ContactService contactService) {
        this.contactService = contactService;

    }

    @GetMapping("/contacts")
    public Iterable<Contact> list() {
        try {
            return contactService.list();
        }catch(EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Contacts Exists",ex);
        }
    }
    @PostMapping("/contacts")
    public Contact addContacts(@RequestBody Contact contact) {

        return contactService.save(contact);
    }

    @GetMapping("/contacts/{id}")
    public Contact getContacts(@PathVariable (value = "id") Long id) {
       try {
           return contactService.getContact(id).orElseThrow(EntityNotFoundException::new);
       }catch(EntityNotFoundException ex) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Contact With Id::"+id+"  does not exist",ex);
       }
    }
    @PutMapping("/contacts/{id}")
    public Contact updateContact(@RequestBody Contact updatedContact,@PathVariable Long id) {
        try {
            return contactService.updateContact(updatedContact, id).orElseThrow(EntityNotFoundException::new);
        }catch(EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," Failed to Update Contact With Id::"+id+" as it does not exist",ex);
        }
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
           try {
               contactService.deleteContact(id);
           }catch(EmptyResultDataAccessException e) {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND," Failed to Delete Contact With Id::"+id+" as it does not exist",e);

           }

    }

    @GetMapping("/contacts/call-list")
    public List<ContactList> getCallList() {
         return contactService.callList();
    }



}
