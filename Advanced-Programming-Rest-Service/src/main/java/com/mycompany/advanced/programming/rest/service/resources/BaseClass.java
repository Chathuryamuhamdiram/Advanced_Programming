/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced.programming.rest.service.resources;
import DB.Token;
import DB.ValidateToken;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public abstract class BaseClass  {
 @Context
    protected HttpHeaders httpHeaders;    
    @Context
    protected HttpServletRequest req;   
    @Context
    protected HttpServletResponse res;
    @PostConstruct
    protected void postConstruct(){
        HttpSession session = req.getSession();
        String authorizationHeader = httpHeaders.getHeaderString("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.replace("Bearer ", "");
            Token tokenObject = ValidateToken.validateTokenAndGetEmail(token);
            if (tokenObject != null) {
                session.setAttribute("email", tokenObject.getEmail());
                session.setAttribute("userid", tokenObject.getUserid());
                session.setAttribute("token", token);
               return; 
            }
        }
      res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } 
}
