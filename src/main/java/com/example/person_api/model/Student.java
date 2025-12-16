package com.example.person_api.model;

public class Student extends Person {
    private String group;

    public Student() {}

    public Student(Long id, String name, int age, String group) {
        super(id, name, age);
        this.group = group;
    }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }
}
