package com.example.sistema;

import com.example.sistema.dao.PersonDAO;
import com.example.sistema.model.Person;
import com.example.sistema.model.Student;
import com.example.sistema.model.Teacher;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PersonDAO dao = new PersonDAO();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String option = scanner.nextLine().trim();
            try {
                switch (option) {
                    case "1": cadastrar(); break;
                    case "2": consultar(); break;
                    case "0": System.out.println("Saindo..."); System.exit(0); break;
                    default: System.out.println("Opção inválida"); break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void showMenu() {
        System.out.println("--- Sistema Cadastro ---");
        System.out.println("1 - Cadastrar (Student ou Teacher)");
        System.out.println("2 - Consultar (listar todos)");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrar() throws Exception {
        System.out.print("Nome: ");
        String name = scanner.nextLine().trim();
        System.out.print("Idade: ");
        int age = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Tipo (S=Student / T=Teacher): ");
        String tipo = scanner.nextLine().trim().toUpperCase();
        Person p;
        if ("T".equals(tipo)) {
            System.out.print("Disciplina (ex: Matemática): ");
            String subj = scanner.nextLine().trim();
            Teacher t = new Teacher(name, age, subj);
            p = t;
        } else {
            System.out.print("Student ID (opcional): ");
            String sid = scanner.nextLine().trim();
            Student s = new Student(name, age, sid);
            p = s;
        }
        dao.insertPerson(p);
        // Polimorfismo: chamando método que é implementado de forma diferente nas subclasses
        System.out.println("Cadastrado: " + p.toString());
    }

    private static void consultar() throws Exception {
        List<Person> list = dao.listAll();
        if (list.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        System.out.println("--- Pessoas cadastradas ---");
        for (Person p : list) {
            // Polimorfismo em ação: getRoleDescription resolve para Student/Teacher concretos
            System.out.println(p.toString());
        }
    }
}
