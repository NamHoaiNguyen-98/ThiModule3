package com.example.thuchanhmodule3.DAO;

import com.example.thuchanhmodule3.connection.MyConnection;
import com.example.thuchanhmodule3.model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO implements IGenerateDAO<Classroom> {
    private static ClassroomDAO classroomDAO;
    private final String SELECT_ALL = "select * from classroom";
    private final String SELECT_BY_ID = "select * from classroom where idClassroom = ?;";
    private final String INSERT_INTO = "insert into classroom(nameClassroom) value (?);";

    private ClassroomDAO(){};
    public static ClassroomDAO getInstance() {
        if(classroomDAO == null) {
            classroomDAO = new ClassroomDAO();
        } return classroomDAO;
    }
    @Override
    public List<Classroom> findAll() {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Classroom> classrooms = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idClassroom = resultSet.getInt("idClassroom");
                String nameClassroom = resultSet.getString("nameClassroom");
                Classroom classroom = new Classroom(idClassroom,nameClassroom);
                classrooms.add(classroom);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return classrooms;
    }

    @Override
    public Classroom findOne(int id) {
        Connection connection = MyConnection.getInstance().getConnection();
        Classroom classroom = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idClassroom = resultSet.getInt("idClassroom");
                String nameClassroom = resultSet.getString("nameClassroom");
                classroom = new Classroom(idClassroom,nameClassroom);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return classroom;
    }

    @Override
    public void create(Classroom classroom) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, classroom.getNameClassroom());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void delete(int id) {


    }

    @Override
    public void update(Classroom classroom) {

    }
}
