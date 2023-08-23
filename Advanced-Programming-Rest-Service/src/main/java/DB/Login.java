/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;




public class Login {
     private int userid;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String user;
    private String dob;
    private String phonenumber;

    public Login(int userid,String email, String password, String firstname, String lastname, String user, String dob, String phonenumber) {
       
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.user = user;
        this.dob = dob;
        this.phonenumber = phonenumber;
    }

    public Login( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Login(int userid, String email, String user) {
        this.userid = userid;
        this.email = email;
        this.user = user;
    }

    public Login(String email, String password, String user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    
    
    public Login(String email) {
        this.email = email;
    }

    public Login(int userid, String email) {
        this.userid = userid;
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
}

