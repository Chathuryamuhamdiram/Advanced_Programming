/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maildb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler {
    static final String DB_URL = "jdbc:mysql://localhost:3306/the_jobs_appoinments?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";
    
      public List<Appointment> getAppointmentsToRemind() {
        List<Appointment> appointments = new ArrayList<>();

        try {
             DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
           String query ="SELECT jd.id, jd.datetime, l.firstname, l.email " +
               "FROM jobseekerdate jd " +
               "JOIN login l ON jd.jobseekerid = l.userid " +
               "WHERE TIMESTAMPDIFF(HOUR, NOW(), jd.datetime) = 1 " +
               "AND jd.reminder_sent = 0";

            
            java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
 
           
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {   
                 int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String email = resultSet.getString("email");
                String datetime = resultSet.getString("datetime");
               
appointments.add(new Appointment(id,firstname, email, datetime ));
            }

            resultSet.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }
      
          public void markAppointmentAsReminderSent(int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "UPDATE jobseekerdate SET reminder_sent = 1 WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            pstmt.close();
           
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
