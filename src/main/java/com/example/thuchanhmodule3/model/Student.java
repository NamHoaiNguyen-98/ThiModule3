package com.example.thuchanhmodule3.model;

import java.time.LocalDate;

public class Student {
    private int idStudent;
    private String name;
    private String email;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private Classroom classroom;

    public Student() {
    }

    public Student(int idStudent, String name, String email, LocalDate dob, String address, String phoneNumber, Classroom classroom) {
        this.idStudent = idStudent;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public Student(String name, String email, LocalDate dob, String address, String phoneNumber, Classroom classroom) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
