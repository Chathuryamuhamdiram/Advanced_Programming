/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthController extends HttpServlet {
    private Map<String, Login> users = new HashMap<>();
    private Map<String, String> tokens = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Login login = users.get(email);

        if (login != null && password.equals(login.getPassword())) {
            String token = generateToken();
            tokens.put(token, email);
            response.sendRedirect("dashboard?token=" + token);
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }

    private String generateToken() {
        return java.util.UUID.randomUUID().toString();
    }
}