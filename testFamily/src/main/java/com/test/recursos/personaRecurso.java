/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.recursos;

import com.google.gson.Gson;
import com.test.dao.interfaces.PersonInterface;
import com.test.models.Persona;
import com.test.service.PersonaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jorge
 */
@Path("/articulos")
public class personaRecurso {
    
    
    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPeronas(){
        Persona persona = new Persona(1,"jorge","1/02/2020","Hombre");
        String json = new Gson().toJson(persona);
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
    }
    
        
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons(){
        List<Persona> persons = new PersonaService().getListPersons();
        String json = new Gson().toJson(persons);
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
        
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id){
        Persona person = new PersonaService().getPerson(id);
        String json = new Gson().toJson(person);
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
        
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id){
        String response = new PersonaService().deletePerson(id);
        return Response.ok(response,MediaType.APPLICATION_JSON).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Persona persona){
        Persona response = new PersonaService().addPerson(persona);
        return Response.ok(response,MediaType.APPLICATION_JSON).build(); 
    }
    

    

    
    
}

