package com.example.thuchanhmodule3.DAO;

import com.example.thuchanhmodule3.connection.MyConnection;
import com.example.thuchanhmodule3.model.Classroom;
import com.example.thuchanhmodule3.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IGenerateDAO<Student> {

    private static StudentDAO studentDAO;
    private final String SELECT_ALL = "select * from student ";
    private final String SELECT_BY_ID = "select * from student where idStudent = ?";
    private final String INSERT_INTO = "insert into student(name, email, dob, address, phoneNumber, idClassroom) value (?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update student set name =?, email =?, dob =?, address =?, phoneNumber =?, idClassroom =? where idStudent =?;";
    private final String DELETE_BY_ID = "delete from student where idStudent=?;";
    private final String SEARCH_BY_NAME = "select * from student where name like ?;";

    private StudentDAO(){};
    public static StudentDAO getInstance() {
        if(studentDAO == null) {
            studentDAO = new StudentDAO();
        } return studentDAO;
    }

    @Override
    public List<Student> findAll() {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("idStudent");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int idClassroom = resultSet.getInt("idClassroom");
                Classroom classroom = ClassroomDAO.getInstance().findOne(idClassroom);
                Student student = new Student(idStudent,name,email,dob,address,phoneNumber,classroom);
                students.add(student);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return students;
    }

    @Override
    public Student findOne(int id) {
        Connection connection = MyConnection.getInstance().getConnection();
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("idStudent");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int idClassroom = resultSet.getInt("idClassroom");
                Classroom classroom = ClassroomDAO.getInstance().findOne(idClassroom);
                student = new Student(idStudent,name,email,dob,address,phoneNumber,classroom);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return student;
    }




    @Override
    public void create(Student student) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3, student.getDob().toString());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getPhoneNumber());
            preparedStatement.setInt(6, student.getClassroom().getIdClassroom());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3, student.getDob().toString());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getPhoneNumber());
            preparedStatement.setInt(6, student.getClassroom().getIdClassroom());
            preparedStatement.setInt(7, student.getIdStudent());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = MyConnection.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    public List<Student> searchByName(String search) {
        Connection connection = MyConnection.getInstance().getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, '%' + search + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("idStudent");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int idClassroom = resultSet.getInt("idClassroom");
                Classroom classroom = ClassroomDAO.getInstance().findOne(idClassroom);
                Student student = new Student(idStudent,name,email,dob,address,phoneNumber,classroom);
                students.add(student);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return students;

}
}