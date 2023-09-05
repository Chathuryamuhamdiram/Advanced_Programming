/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dbp.JobSeeker;
import dbp.ViewAppointmentUtils;
import java.util.List;


import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("viewappointment")
@RequestScoped
public class ViewappointmentResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobSeekerInfo() {
         ViewAppointmentUtils utils = new ViewAppointmentUtils();
        List<JobSeeker> jobSeekers = utils.getAllJobSeekers(); // Call your method to get job seeker information

        if (jobSeekers != null) {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(jobSeekers);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(500).build();
        }
    }
  @DELETE
    @Path("/{userid}")
    public Response deleteJobSeeker(@PathParam("userid") int userid) {
        ViewAppointmentUtils utils = new ViewAppointmentUtils();
        boolean success = utils.deleteJobSeeker(userid);

        if (success) {
            return Response.ok().build();
        } else {
            return Response.status(500).build();
        }
    }
}
