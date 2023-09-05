/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbp;

import dbp.Profile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProfileUtils {
   static final String DB_URL = "jdbc:mysql://localhost:3306/the_jobs_appoinments?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";

    
     public boolean addProfile(String firstname, String lastname,String dob,String address,String email, String phonenumber,String job,String education,int userId) {
          try {
              System.out.println("your in");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               String sql = "INSERT INTO profile ( firstname,lastname,dob,address,email,phonenumber,job,education,puserid) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql); 
            
             preparedStatement.setString(1, firstname);
             preparedStatement.setString(2, lastname);
             preparedStatement.setString(3, dob);
             preparedStatement.setString(4, address);
             preparedStatement.setString(5, email);
             preparedStatement.setString(6, phonenumber);
             preparedStatement.setString(7, job);
             preparedStatement.setString(8, education);
             preparedStatement.setInt(9, userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            return true;
               
          }   catch (SQLException e) {
                e.printStackTrace();
            return false;
             } 
        } 
          
     
public List<Profile> getAllProfiles(int puserid) {
    List<Profile> profiles = new ArrayList<>();
    try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM profile WHERE puserid = ?");
        ) {
            stmt.setInt(1, puserid); // Set the parameter value

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String dob = resultSet.getString("dob");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phonenumber = resultSet.getString("phonenumber");
                    String job = resultSet.getString("job");
                    String education = resultSet.getString("education");

                    profiles.add(new Profile(id, firstname, lastname, dob, address, email, phonenumber, job, education));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return profiles;
} 
}
