package com.example.sistema.model;

// Herança: Teacher extende Person
public class Teacher extends Person {
    private String subject;

    public Teacher() { super(); }

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Polimorfismo: implementação específica de getRoleDescription
    @Override
    public String getRoleDescription() {
        return "Teacher";
    }
}
