package com.projeto.sistema.dao;

import com.projeto.sistema.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void insert(Person p) {
        String sql = "INSERT INTO person (name, type, course, subject) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getName());
            stmt.setString(2, p.getType());

            if (p instanceof Student) {
                stmt.setString(3, ((Student) p).getCourse());
                stmt.setString(4, null);
            } else {
                stmt.setString(3, null);
                stmt.setString(4, ((Teacher) p).getSubject());
            }

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT * FROM person";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");

                if (type.equals("STUDENT")) {
                    list.add(new Student(id, name, rs.getString("course")));
                } else {
                    list.add(new Teacher(id, name, rs.getString("subject")));
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }

        return list;
    }
}
