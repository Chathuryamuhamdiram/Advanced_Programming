/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;

import dbp.ProfileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dbp.Profile;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author User
 */

@Path("profile")
@RequestScoped
public class ProfileResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProfile(String json) {
        Gson gson = new GsonBuilder().create();
        Profile addprof = gson.fromJson(json, Profile.class);
        
        ProfileUtils utils = new ProfileUtils(); 
        boolean result = utils.addProfile(addprof.getFirstname(),addprof.getLastname(),addprof.getDob(),addprof.getAddress(),addprof.getEmail(),addprof.getPhonenumber(),addprof.getJob(),addprof.getEducation(),addprof.getUserid());
        if (result) {
            return Response.status(201).build();
        } else {
            return Response.status(500).build();
        }
    }
    
    @GET
    @Path("/{userid}")
@Produces(MediaType.APPLICATION_JSON)
public Response getProfileDetails(@PathParam("userid") int userid) {
    ProfileUtils utils = new ProfileUtils();
    List<Profile> profiles = utils.getAllProfiles(userid);
    
    if (profiles != null && !profiles.isEmpty()) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(profiles);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    } else {
        return Response.status(404).build(); // Profile not found
    }
}
}

