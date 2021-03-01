package com.silverstone.sample.contactsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Embeddable
public class Phone {

    private String number;
    private PhoneType type;
    public Phone() {
    }
}
