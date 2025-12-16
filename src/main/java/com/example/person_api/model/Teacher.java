package com.example.person_api.model;

public class Teacher extends Person {
    private String subject;

    public Teacher() {}

    public Teacher(Long id, String name, int age, String subject) {
        super(id, name, age);
        this.subject = subject;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
