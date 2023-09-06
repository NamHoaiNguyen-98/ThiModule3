package com.example.thuchanhmodule3.model;

public class Classroom {
    private int idClassroom;
    private String nameClassroom;

    public Classroom() {
    }

    public Classroom(int idClassroom, String nameClassroom) {
        this.idClassroom = idClassroom;
        this.nameClassroom = nameClassroom;
    }


    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getNameClassroom() {
        return nameClassroom;
    }

    public void setNameClassroom(String nameClassroom) {
        this.nameClassroom = nameClassroom;
    }
}
