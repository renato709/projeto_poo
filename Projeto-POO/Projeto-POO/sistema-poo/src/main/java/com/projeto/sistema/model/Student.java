package com.projeto.sistema.model;

public class Student extends Person {
    private String course;

    public Student(String name, String course) {
        super(name);
        this.course = course;
    }

    public Student(int id, String name, String course) {
        super(id, name);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}
