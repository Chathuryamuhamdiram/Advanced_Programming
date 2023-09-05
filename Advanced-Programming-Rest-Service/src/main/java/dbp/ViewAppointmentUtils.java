/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewAppointmentUtils {
    
     static final String DB_URL = "jdbc:mysql://localhost:3306/the_jobs_appoinments?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";
    
    public List<JobSeeker> getAllJobSeekers() {
    List<JobSeeker> jobSeekers = new ArrayList<>();
    try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
           ResultSet resultSet = stmt.executeQuery("SELECT l.userid AS userid, l.firstname AS firstname, jd.datetime AS datetime " +
             "FROM login l " +
             "INNER JOIN jobseekerdate jd ON l.userid = jd.jobseekerid " + 
             "WHERE DATE(jd.datetime) = CURDATE()");
        ) {
            while (resultSet.next()) {
                int userid = resultSet.getInt("userid");
                String firstname = resultSet.getString("firstname");
                String datetime = resultSet.getString("datetime");
               

                jobSeekers.add(new JobSeeker(userid, firstname, datetime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return jobSeekers;
}
    
    public boolean deleteJobSeeker(int userid) {
    try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM jobseekerdate WHERE jobseekerid = ?");
        ) {
            stmt.setInt(1, userid);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}
