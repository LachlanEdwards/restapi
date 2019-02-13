/*package com.metlease.DAO.Helpers;

import com.metlease.Enumerators.UserGender;
import com.metlease.Exceptions.DuplicateException;
import com.metlease.Exceptions.SIDException;
import com.metlease.Entity.Building;
import com.metlease.Entity.User;
import com.metlease.Passwords.Encrypt;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class DataInsertion {
    public static User newUser(String first, String last, String mail, String phone, String image, UserGender gender, Date birthday, String password) throws DuplicateException {
        try {
            Connection connection = new Connection();
            PreparedStatement duplicate_stmt = connection.getConnection().prepareStatement("SELECT mail FROM Users WHERE mail = ?");
            duplicate_stmt.setString(1, mail);
            boolean duplicate = connection.duplicatePresent(duplicate_stmt);
            if (duplicate) {
                throw new DuplicateException("Duplicate UserData exists.");
            } else {
                String hash = Encrypt.hash(password);
                PreparedStatement stmt = connection.getConnection().prepareStatement("INSERT INTO Users(first,last,mail,phone,image,gender,birthday,password) VALUES (?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, first);
                stmt.setString(2, last);
                stmt.setString(3, mail);
                stmt.setString(4, phone);
                stmt.setString(5, image);
                stmt.setInt(6, gender.toInt());
                stmt.setString(7, DateFormatter.toMySQLFormat(birthday));
                stmt.setString(8, password);
                long id = connection.Insert(stmt);
                connection.closeConnection();
                return new User();
            }
        } catch (SIDException | SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    public static Building newBuilding() {
        return null;
    }
}*/
