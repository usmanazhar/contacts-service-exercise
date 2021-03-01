package com.silverstone.sample.contactsservice.repository;

import com.silverstone.sample.contactsservice.model.Contact;
import com.silverstone.sample.contactsservice.model.PhoneType;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ContactsRepository extends CrudRepository<Contact,Long> {

    List<ContactHomeType> findContactByPhone_Type(PhoneType type);
}
