package com.userlist.dao;

import com.userlist.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao
{
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        String databaseURL = "jdbc:h2:~/data/test;MODE=MYSQL;DB_CLOSE_DELAY=-1";
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(databaseURL, "sa", "");
        return connection;
    }

    public void addUser (String name, String surname, String password) throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();
        String addUser = "INSERT INTO USER_TABLE (USER_NAME, USER_SURNAME, USER_PASS) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, password);
        preparedStatement.executeUpdate();
    }

    public void removeUser (int id) throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();
        String removeUser = "DELETE FROM USER_TABLE WHERE USER_ID = " + id;
        PreparedStatement preparedStatement = connection.prepareStatement(removeUser);
        preparedStatement.executeUpdate();
    }

    public static List<User> listUsers() throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();
        String getRecords = "SELECT USER_ID, USER_NAME, USER_SURNAME, USER_PASS FROM USER_TABLE";

        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getRecords);
        List<User> list = new ArrayList<User>();

        while(resultSet.next())
            list.add(new User(
                    resultSet.getInt("USER_ID"),
                    resultSet.getString("USER_NAME"),
                    resultSet.getString("USER_SURNAME"),
                    resultSet.getString("USER_PASS")));

        return list;
    }

    public Boolean signInUser(String name, String password) throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();

        String signIn = "SELECT USER_NAME, USER_PASS FROM USER_TABLE WHERE USER_NAME = '" + name + "' AND USER_PASS = '" + password + "'";
        Statement statement= connection.createStatement();

        ResultSet resultSet = statement.executeQuery(signIn);
        if(resultSet.next())
            return true;
        return false;
    }
}
