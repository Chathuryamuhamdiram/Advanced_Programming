/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maildb;


class Appointment {
   
    private Integer id;
    private String firstname;
    private String email;
     private String datetime;


    public Appointment(String firstname, String email, String datetime) {
        this.firstname = firstname;
        this.email = email;
        this.datetime = datetime;
    }

    public Appointment(Integer id, String firstname, String email, String datetime) {
        this.id = id;
        this.firstname = firstname;
        this.email = email;
        this.datetime = datetime;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
   
}
