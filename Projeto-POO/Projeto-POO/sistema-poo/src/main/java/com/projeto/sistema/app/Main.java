package com.projeto.sistema.app;

import com.projeto.sistema.dao.PersonDAO;
import com.projeto.sistema.model.Student;
import com.projeto.sistema.model.Teacher;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PersonDAO dao = new PersonDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- SISTEMA ESCOLAR ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> consultar();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrar() {
        System.out.println("\nCadastrar:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            dao.insert(new Student(nome, curso));
            System.out.println("Aluno cadastrado!");
        } else {
            System.out.print("Disciplina: ");
            String disc = scanner.nextLine();

            dao.insert(new Teacher(nome, disc));
            System.out.println("Professor cadastrado!");
        }
    }

    private static void consultar() {
        System.out.println("\n--- LISTA DE PESSOAS ---");
        dao.findAll().forEach(p ->
                System.out.println("ID: " + p.getId() +
                        " | Nome: " + p.getName() +
                        " | Tipo: " + p.getType())
        );
    }
}
