/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class TokenService {
    
 private Map<String, Token> tokens = new HashMap<>();
    
    public Token findByToken(String token) {
        return tokens.get(token);
    }
    
    public String generateToken(Login login) {
        String tokenValue = generateUniqueToken();
        Token token = new Token(tokenValue, login);
        tokens.put(tokenValue, token);
        return tokenValue;
    }
    
    private String generateUniqueToken() {
        return UUID.randomUUID().toString();
    }
}
