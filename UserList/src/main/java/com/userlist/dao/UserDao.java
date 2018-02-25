package com.userlist.dao;

import com.userlist.model.Auto;
import com.userlist.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao
{
    static public User currentUser = new User(0, null, null, null, null);

    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        String databaseURL = "jdbc:h2:~/data/test;MODE=MYSQL;DB_CLOSE_DELAY=-1";
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(databaseURL, "sa", "");
        return connection;
    }

    public boolean addUser (String name, String surname, String password, String description, Integer role) throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();
        String test = "SELECT * FROM USER_TABLE WHERE USER_NAME = '" +  name + "'";
        Statement testStatement = connection.createStatement();
        ResultSet resultSet = testStatement.executeQuery(test);

        if(resultSet.next())
            return false;

        String addUser = "INSERT INTO USER_TABLE (USER_NAME, USER_SURNAME, USER_PASS, USER_DESC, ROLE_ID) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, role);
        preparedStatement.executeUpdate();
        return true;
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
        String getRecords = "SELECT * FROM USER_TABLE";

        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getRecords);
        List<User> list = new ArrayList<User>();

        while(resultSet.next())
            list.add(new User(
                    resultSet.getInt("USER_ID"),
                    resultSet.getString("USER_NAME"),
                    resultSet.getString("USER_SURNAME"),
                    resultSet.getString("USER_PASS"),
                    resultSet.getString("USER_DESC")
            ));
        return list;
    }

    public String signInUser(String name, String password) throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();

        String signIn = "SELECT * FROM USER_TABLE WHERE USER_NAME = '" + name + "' AND USER_PASS = '" + password + "'";
        Statement statement= connection.createStatement();

        ResultSet resultSet = statement.executeQuery(signIn);
        if(resultSet.next())
        {
            currentUser.setId(resultSet.getInt("USER_ID"));
            currentUser.setName(resultSet.getString("USER_NAME"));
            currentUser.setSurname(resultSet.getString("USER_SURNAME"));
            currentUser.setPassword(resultSet.getString("USER_PASS"));
            currentUser.setDescription(resultSet.getString("USER_DESC"));
            currentUser.setRole(resultSet.getInt("ROLE_ID"));
            if(currentUser.getRole() == 1)
                return "user";
            else
                return "admin";
        }
        return null;
    }

    public List<Auto> getAuto (String name) throws SQLException, ClassNotFoundException
    {
        List<Auto> listAuto = new ArrayList<Auto>();
        Connection connection = getConnection();
        String auto = "SELECT USER_TABLE.USER_NAME, AUTO.AUTO_ID, AUTO.AUTO_NAME, AUTO.AUTO_IMG " +
                "FROM USER_TABLE " +
                "INNER JOIN OWNERS " +
                "ON USER_TABLE.USER_ID = OWNERS.USER_ID " +
                "INNER JOIN AUTO " +
                "ON AUTO.AUTO_ID = OWNERS.AUTO_ID " +
                "WHERE USER_TABLE.USER_NAME = '" + name + "'";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(auto);
        while (resultSet.next())
        {
            listAuto.add(new Auto(
                    resultSet.getInt("AUTO.AUTO_ID"),
                    resultSet.getString("USER_TABLE.USER_NAME"),
                    resultSet.getString("AUTO.AUTO_NAME"),
                    resultSet.getString("AUTO.AUTO_IMG")
            ));
        }
        return listAuto;
    }

    public List<Auto> getAllAuto() throws SQLException, ClassNotFoundException
    {
        List<Auto> listAuto = new ArrayList<Auto>();
        Connection connection = getConnection();
        String auto = "SELECT * FROM AUTO";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(auto);
        while (resultSet.next())
        {
            listAuto.add(new Auto(
                    resultSet.getInt("AUTO_ID"),
                    resultSet.getString("AUTO_NAME"),
                    resultSet.getString("AUTO_IMG")
            ));
        }
        return listAuto;
    }

    public void addCar(Integer id) throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();
        String car = "INSERT INTO OWNERS (AUTO_ID, USER_ID) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(car);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, currentUser.getId());
        preparedStatement.executeUpdate();
    }

    public void removeCar(Integer id) throws SQLException, ClassNotFoundException
    {
        Connection connection = getConnection();
        String car = "DELETE FROM OWNERS WHERE AUTO_ID = ? AND USER_ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(car);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, currentUser.getId());
        preparedStatement.executeUpdate();
    }
}
