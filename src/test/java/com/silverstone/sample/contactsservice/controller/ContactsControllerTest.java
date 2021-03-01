package com.silverstone.sample.contactsservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silverstone.sample.contactsservice.model.Contact;
import com.silverstone.sample.contactsservice.service.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import java.io.FileInputStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ContactsController.class)
public class ContactsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testGetContacts() throws Exception {
        RequestBuilder request = get("/contacts/");
        final FileInputStream fileInputStream = new FileInputStream(ResourceUtils.getFile("src/test/resources/contact_test.json"));
        final String staticResponse = StreamUtils.copyToString(fileInputStream, Charset.defaultCharset());

        Iterable<Contact>  mockInvoiceResponse = mapper.readValue(staticResponse, Iterable.class);

        when(contactService.list())
                .thenReturn(mockInvoiceResponse);
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(result.getResponse().getStatus(), 200);
      }
}
