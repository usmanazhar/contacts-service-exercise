package com.silverstone.sample.contactsservice.model;

public enum PhoneType {
    home("h"),work("o"), mobile("m");
    private String type;
    private PhoneType(String type) {
        this.type = type;
    }
    public String getType() {
      return type;
    }
}
