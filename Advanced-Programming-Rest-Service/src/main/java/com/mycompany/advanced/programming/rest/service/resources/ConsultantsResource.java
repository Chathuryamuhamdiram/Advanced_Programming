/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;

import dbp.Consultant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("consultants")
@RequestScoped
public class ConsultantsResource {

static final String DB_URL = "jdbc:mysql://localhost:3306/appointmentscheduling?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#jayan1998#";
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsultantsSchedule() {
        try {
            List<Consultant> consultantList = new ArrayList<>();
            
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT l.firstname, c.datetime " +
               "FROM consultant c " +
               "INNER JOIN login l ON c.consultantid = l.userid " +
               "ORDER BY c.datetime DESC";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String name = resultSet.getString("firstname");
                String datetime = resultSet.getString("datetime");
                consultantList.add(new Consultant(name, datetime));
            }
            
            conn.close();
            
            return Response.ok(consultantList).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }
}
