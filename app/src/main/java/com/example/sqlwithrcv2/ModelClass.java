package com.example.sqlwithrcv2;

public class ModelClass {
    String Name;
    String Number;
    String Email;

    public ModelClass(String name, String number, String email) {
        Name = name;
        Number = number;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

