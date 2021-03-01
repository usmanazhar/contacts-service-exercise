package com.silverstone.sample.contactsservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.silverstone.sample.contactsservice.model.Contact;
import com.silverstone.sample.contactsservice.service.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ContactsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ContactService contactService) {
        return args -> {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<Contact> typeReference = new TypeReference<Contact>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/input/contact.json");
            try {
                Contact contact = objectMapper.readValue(inputStream,typeReference);
                Contact savedContact = contactService.save(contact);

            }catch(IOException e) {
                // Todo
                e.printStackTrace();
                throw new IOException(e);
            }
        };
    }

}
