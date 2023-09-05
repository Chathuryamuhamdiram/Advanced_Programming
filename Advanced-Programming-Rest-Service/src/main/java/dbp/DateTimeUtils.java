package dbp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateTimeUtils extends HttpServlet{
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/the_jobs_appoinments?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";
    
       public boolean saveDateTime(String selectedDateTime,int userId) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO consultant (datetime,consultantid) VALUES (?,?)";
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
       
       
public boolean saveOrUpdateDateTime(String selectedDateTime, int userId) {
    try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        // Fetch the most recent datetime for the given userId
        String selectSql = "SELECT datetime FROM consultant WHERE consultantid = ? ORDER BY datetime DESC LIMIT 1";
        PreparedStatement selectStatement = conn.prepareStatement(selectSql);
        selectStatement.setInt(1, userId);
        ResultSet resultSet = selectStatement.executeQuery();
        
        if (resultSet.next()) {
            String mostRecentDatetime = resultSet.getString("datetime");
            
            // Update the most recent datetime for the given userId
            String updateSql = "UPDATE consultant SET datetime = ? WHERE consultantid = ? AND datetime = ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setString(1, selectedDateTime);
            updateStatement.setInt(2, userId);
            updateStatement.setString(3, mostRecentDatetime);
            int rowsAffected = updateStatement.executeUpdate();
            
            selectStatement.close();
            updateStatement.close();
            conn.close();
            
            return rowsAffected > 0;
        } else {
            // No records found for the given userId, insert a new record
            String insertSql = "INSERT INTO consultant (datetime,consultantid) VALUES (?,?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSql);
            insertStatement.setString(1, selectedDateTime);
            insertStatement.setInt(2, userId);
            int rowsAffected = insertStatement.executeUpdate();
            
            selectStatement.close();
            insertStatement.close();
            conn.close();
            
            return rowsAffected > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


}
