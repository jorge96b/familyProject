/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.recursos;

import com.google.gson.Gson;
import com.test.models.Hijo;
import com.test.models.Persona;
import com.test.service.HijoService;
import com.test.service.PersonaService;
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
@Path("/hijos")
public class HijoRecursos {
    
        
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHijos(){
        List<Hijo> hijos = new HijoService().getListHijos();
        String json = new Gson().toJson(hijos);
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
        
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHijo(@PathParam("id") int id){
        Hijo hijo = new HijoService().getHijo(id);
        String json = new Gson().toJson(hijo);
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
        
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteHijo(@PathParam("id") int id){
        String response = new HijoService().deletePerson(id);
        return Response.ok(response,MediaType.APPLICATION_JSON).build(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHijo(Hijo hijo){
        Hijo response = new HijoService().addPerson(hijo);
        return Response.ok(response,MediaType.APPLICATION_JSON).build(); 
    }
    

    
}
