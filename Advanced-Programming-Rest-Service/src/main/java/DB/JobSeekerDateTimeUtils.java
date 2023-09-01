/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import static DB.DateTimeUtils.DB_URL;
import static DB.DateTimeUtils.PASS;
import static DB.DateTimeUtils.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobSeekerDateTimeUtils {
     static final String DB_URL = "jdbc:mysql://localhost:3306/appointmentscheduling?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";
    
     public boolean saveJobseekerDateTime(String selectedDateTime,int userId) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO jobseekerdate (datetime,jobseekerid) VALUES (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

             preparedStatement.setString(1, selectedDateTime);
             preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }  
    
}
