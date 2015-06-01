/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bism.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Naeem
 */
@Path("/Service3")
public class Service3 {

    @Path("/bism/{param1}")
    @GET
    public String salaam(@PathParam("param1") String pName) {
        return "Assalamu Alaikum " + pName;
    }
    
    
    @GET
    public String salaamDef() {
        return "Assalamu Alaikum DEFAULT";
    }
    
}
