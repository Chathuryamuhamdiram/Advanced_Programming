/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dbp.DateTimeUtils;
import dbp.datetime;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("updatedatetime")
@RequestScoped
public class UpdatedatetimeResource {

 @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDateTime(String json) {
        Gson gson = new GsonBuilder().create();
        datetime date = gson.fromJson(json, datetime.class);

        DateTimeUtils utils = new DateTimeUtils();
               boolean result = utils.saveOrUpdateDateTime(date.getDatetime(), date.getUserid()); // Call the saveOrUpdateDateTime method
 // Call the updateDateTime method with userId
        if (result) {
            return Response.status(200).build();
        } else {
            return Response.status(500).build();
        }
    }
}
