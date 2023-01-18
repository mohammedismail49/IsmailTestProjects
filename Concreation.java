package com.GHomePack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Concreation {

    static Connection setConnection() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GHomeDATA" , "root", "sespl!@3");
        return connection;
    }

}
