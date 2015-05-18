/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bism.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Naeem
 */
@Path("/Service3")
public class Service3 {

    @Path("/bism")
    @GET
    public String salaam() {
        return "Assalamu Alaikum";
    }
    
    
    @GET
    public String salaamDef() {
        return "Assalamu Alaikum DEFAULT";
    }
    
}
