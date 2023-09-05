/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbp;


public class Token {
    
     private String tokenValue;
    private Login login; 
    private Integer id;
    private String token;
    private Integer userid;
     private String user;
     private String email;

    public Token(String token, Login login) {
        this.id = id;
        this.token = token;
        this.userid = userid;
    }

  public Token(String token, Login login, Integer id, String email, Integer userid) {
    this.id = id;
    this.token = token;
    this.email = email;
    this.userid = userid;
}

    public Token(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Token(String token, String email, Integer userid) {
    this.token = token;
    this.email = email;
    this.userid = userid;
}

public Token(String email, Integer userid) {
    this.email = email;
    this.userid = userid;
}
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    
    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
