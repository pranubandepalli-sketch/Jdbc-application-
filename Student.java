package com.example.studentmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Student {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Course is required")
    private String course;

    private String phone;

    public Student() {}

    public Student(Long id, String name, String email, String course, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
