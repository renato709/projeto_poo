package com.example.sistema.model;

// Abstração: classe abstrata Person define comportamento comum
public abstract class Person {
    // Encapsulamento: campos privados com getters/setters
    private int id;
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstrato: forçando subclasses a implementarem descrição de papel
    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return String.format("Person{id=%d, name='%s', age=%d, role=%s}", id, name, age, getRoleDescription());
    }
}
