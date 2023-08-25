/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;


public class LoginUtils extends HttpServlet  {
    static final String DB_URL = "jdbc:mysql://localhost:3306/the_jobs_appoinments?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";


  public Login loginUser(String email, String password) {
    try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("SELECT userid, user FROM login WHERE email=? AND password=?")
        ) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            // Execute the query
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int userid = rs.getInt("userid");
                    String userType = rs.getString("user"); // Retrieve user type
                    return new Login(email, password, userType); // Pass user type to the constructor
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
    
            public boolean addUser(Login login) {
          try {
              System.out.println("your in");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
             ) {		      
               stmt.executeUpdate("INSERT INTO login (email, password, firstname,lastname,user,dob,phonenumber) "
                       + "VALUES ('" + login.getEmail() + "', '" + login.getPassword() + "', '" + login.getFirstname() +"','" + login.getLastname() + "','" + login.getUser() +"', '" + login.getDob() + "', '" + login.getPhonenumber() +"')");
               return true;
             } catch (SQLException e) {
                 System.out.println(e);
             } 
        } catch(SQLException e) {
            System.out.println(e);
        }     
        return false;
    }
            
   
}
