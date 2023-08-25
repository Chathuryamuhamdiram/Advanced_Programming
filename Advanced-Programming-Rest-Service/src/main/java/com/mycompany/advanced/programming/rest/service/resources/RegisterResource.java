/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;

import DB.Login;
import DB.LoginUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("register")
@RequestScoped
public class RegisterResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(String json) {
        Gson gson = new GsonBuilder().create();
        Login add = gson.fromJson(json, Login.class);
        
        LoginUtils utils = new LoginUtils(); 
        boolean result = utils.addUser(add);
        if (result) {
            return Response.status(201).build();
        } else {
            return Response.status(500).build();
        }
    }
}

