/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbp;

import java.util.ArrayList;
import java.util.List;




public class UserService {
    
    public Login findByUsername(String email) {
        // Replace this with your actual logic to retrieve Login by email
        // For example, you can use JDBC to fetch the user from the database
        // Here's a mock implementation assuming you have a List of Logins
        List<Login> logins = new ArrayList<>(); // Initialize with your actual data
        for (Login login : logins) {
            if (login.getEmail().equals(email)) {
                return login;
            }
        }
        return null; // Return null if no matching user is found
    }
    
}
