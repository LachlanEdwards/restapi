package com.metlease.Entity.Helpers;
import java.sql.*;


public class Connection {
    private java.sql.Connection connection;
    public Connection() {
        try {
            String database = "metlease";
            String url = "jdbc:mysql://localhost:3306/" + database + "?useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "ifb299sql";

            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public java.sql.Connection getConnection() {
        return this.connection;
    }

    public ResultSet RS(PreparedStatement statement) {
        try {
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("SQL Error Encountered: \nError Code: " + e.getErrorCode() + "\nError Response: " + e.getMessage());
            return null;
        }
    }

    public boolean duplicatePresent(PreparedStatement statement) {
        try {
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SQL Error Encountered: \nError Code: " + e.getErrorCode() + "\nError Response: " + e.getMessage());
            return true;
        }
    }

    public void Change(String query) {

    }

    public int Insert(PreparedStatement query) {
        try {
            PreparedStatement response = query;
            response.executeUpdate();
            ResultSet ids = response.getGeneratedKeys();
            if (ids.next()) {
                return ids.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("SQL Error Encountered: \nError Code: " + e.getErrorCode() + "\nError Response: " + e.getMessage());
            return -1;
        }

    }
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL Error Encountered: \nError Code: " + e.getErrorCode() + "\nError Response: " + e.getMessage());
        }
    }

}
