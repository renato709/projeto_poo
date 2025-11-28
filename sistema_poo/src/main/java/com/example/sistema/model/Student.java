package com.example.sistema.model;

// Herança: Student extende Person
public class Student extends Person {
    private String studentId;

    public Student() { super(); }

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Polimorfismo: implementação específica de getRoleDescription
    @Override
    public String getRoleDescription() {
        return "Student";
    }
}
