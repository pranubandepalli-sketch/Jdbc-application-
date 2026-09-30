package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final org.springframework.jdbc.core.RowMapper<Student> mapper = (rs, rowNum) ->
        new Student(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("course"),
            rs.getString("phone")
        );

    public List<Student> findAll() {
        return jdbc.query("SELECT id, name, email, course, phone FROM students ORDER BY id DESC", mapper);
    }

    public Student findById(Long id) {
        return jdbc.queryForObject(
            "SELECT id, name, email, course, phone FROM students WHERE id = ?",
            mapper, id
        );
    }

    public void save(Student s) {
        jdbc.update(
            "INSERT INTO students (name, email, course, phone) VALUES (?, ?, ?, ?)",
            s.getName(), s.getEmail(), s.getCourse(), s.getPhone()
        );
    }

    public void update(Student s) {
        jdbc.update(
            "UPDATE students SET name=?, email=?, course=?, phone=? WHERE id=?",
            s.getName(), s.getEmail(), s.getCourse(), s.getPhone(), s.getId()
        );
    }

    public void delete(Long id) {
        jdbc.update("DELETE FROM students WHERE id=?", id);
    }
}
