/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.enterprise.context.RequestScoped;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;


@Path("validateToken")
@RequestScoped
public class ValidateTokenResource extends BaseClass {           
@POST
    public Response getToken(String json,@Context HttpServletRequest request) {

         Gson gson = new GsonBuilder().create();
        // Check if the user is authenticated (e.g., by checking a session)
        HttpSession session = request.getSession();
        String tokenValue = (String) session.getAttribute("token");
         String email = (String) session.getAttribute("email");
        Integer userId = (Integer) session.getAttribute("userid");
 System.out.println( "token ");
        if (tokenValue != null && email != null && userId != null) {

             return Response.status(200)
                .entity("{\"email\": \"" + email + "\", \"userid\": " + userId.toString() + "}")
                .build(); // Return the token with email and user ID
            }
        
        return Response.status(401).build(); // Unauthorized or token invalid
    }
}
