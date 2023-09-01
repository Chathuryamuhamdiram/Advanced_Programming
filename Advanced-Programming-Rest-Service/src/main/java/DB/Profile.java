/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


public class Profile {
    
    private int id;
    private String firstname;
    private String lastname;
    private String dob;
    private String address;
    private String email;
    private String phonenumber; 
    private String job;
    private String education;
    private int puserid;
    private int userid;

    public Profile(String firstname, String lastname, String dob, String address, String email, String phonenumber, String job, String education) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.job = job;
        this.education = education;
    }

    public Profile(int id, String firstname, String lastname, String dob, String address, String email, String phonenumber, String job, String education) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.job = job;
        this.education = education;
    }

    public Profile(int id, String firstname, String lastname, String dob, String address, String email, String phonenumber, String job, String education, int puserid) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.job = job;
        this.education = education;
        this.puserid = puserid;
    }

    public Profile(int id, String firstname, String lastname, String dob, String address, String email, String phonenumber, String job, String education, int puserid, int userid) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.job = job;
        this.education = education;
        this.puserid = puserid;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getPuserid() {
        return puserid;
    }

    public void setPuserid(int puserid) {
        this.puserid = puserid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
      
}
