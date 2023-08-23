/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenUtils {
    
     static final String DB_URL = "jdbc:mysql://localhost:3306/the_jobs_appoinments?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";
    
     private static final Map<String, Token> tokens = new HashMap<>();

    public Token generateToken(Login login) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token(tokenValue, login);
        
          // Save the token in the user table
        saveTokenInUserTable(login.getEmail(), tokenValue);
        
        tokens.put(tokenValue, token);
        return token; // Return the generated token
    }

    public Token validateToken(String tokenValue) {
        return tokens.get(tokenValue); 
    }
    
     private void saveTokenInUserTable(String email, String token) {
        // Assuming you have a database connection setup
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = conn.prepareStatement(
                     "UPDATE login SET token = ? WHERE email = ?")) {
            
            statement.setString(1, token);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
