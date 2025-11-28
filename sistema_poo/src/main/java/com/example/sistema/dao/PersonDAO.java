package com.example.sistema.dao;

import com.example.sistema.model.Person;
import com.example.sistema.model.Student;
import com.example.sistema.model.Teacher;
import com.example.sistema.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO: responsável por persistir Person em banco (JDBC)
public class PersonDAO {

    public void insertPerson(Person p) throws SQLException {
        String sql = "INSERT INTO persons (name, age, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getRoleDescription());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<Person> listAll() throws SQLException {
        List<Person> result = new ArrayList<>();
        String sql = "SELECT id, name, age, role FROM persons ORDER BY id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String role = rs.getString("role");
                Person p;
                if ("Teacher".equalsIgnoreCase(role)) {
                    p = new Teacher(name, age, null);
                } else {
                    p = new Student(name, age, null);
                }
                p.setId(id);
                result.add(p);
            }
        }
        return result;
    }
}
