/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bism.rest;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
/**
 *
 * @author niqbal
 */
@Path("/ftocservice")
public class PartsController{
    
 
	  @GET
	  @Produces("application/json")
	  public Response convertFtoC()  {
 
		Gson gson= new Gson();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32)*5/9; 
                Temperature temp = new Temperature();
                temp.celsius = celsius;
                temp.fahrenheit = fahrenheit;
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + gson.toJson(temp);
		return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) {
 
              Gson gson = new Gson();
		float celsius;
		celsius =  (f - 32)*5/9; 
                Temperature temp = new Temperature();
                temp.celsius = celsius;
                temp.fahrenheit = f;
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + gson.toJson(temp);
		return Response.status(200).entity(result).build();
	  }   
}

class Temperature
{
    double celsius;
    double fahrenheit;
}