package com.example.thuchanhmodule3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private final String URL ="jdbc:mysql://localhost:3306/MD3?useSSL=false";
    private final String username ="root";
    private final String passWord ="123456";
    private static MyConnection myConnection;

    public MyConnection() {
    }
    public static MyConnection getInstance(){
        if (myConnection == null){
            myConnection = new MyConnection();
        }return myConnection;
    }
    public Connection getConnection(){
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,username,passWord);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
