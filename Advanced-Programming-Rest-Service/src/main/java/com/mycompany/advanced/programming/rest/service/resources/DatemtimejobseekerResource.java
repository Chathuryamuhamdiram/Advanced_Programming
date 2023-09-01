/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import DB.JobSeekerDateTimeUtils;
import DB.datetime;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ashinka
 */
@Path("datemtimejobseeker")
@RequestScoped
public class DatemtimejobseekerResource {

   @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveDateTime(String json) {
        Gson gson = new GsonBuilder().create();
        datetime date = gson.fromJson(json, datetime.class);

        JobSeekerDateTimeUtils utils = new JobSeekerDateTimeUtils();
        boolean result = utils.saveJobseekerDateTime(date.getDatetime(), date.getUserid()); // Change this line
        if (result) {
            return Response.status(201).build();
        } else {
            return Response.status(500).build();
        }
    }
}
