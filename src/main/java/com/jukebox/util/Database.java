package com.jukebox.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection()
    {
        Connection connection=null;
        String url="jdbc:mysql://localhost:3306/jukebox";
        String user="Sangti";
        String password="Atykonyak1#";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,user,password);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

}
