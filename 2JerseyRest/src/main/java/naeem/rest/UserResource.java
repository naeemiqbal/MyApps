package naeem.rest;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public class UserResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    final Logger LOG = Logger.getLogger(getClass().getName());
    

    UserService userService;

    public UserResource(UriInfo uriInfo, Request request, String id) {
        LOG.setLevel(Level.ALL);
        LOG.fine("UserResourece " + id);  
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        userService = new UserService();
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public User getUser() {
        User user = userService.getUser(id);
        LOG.fine("get json " + user.toString());                
        return user;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(InputStream inpstr) {
        Gson json = new Gson();        
        User user = json.fromJson(new InputStreamReader(inpstr), User.class);
        LOG.fine("Post Insert json " + user.toString());        
        userService.createUser(user);
    }    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUser(InputStream inpstr) {
        Gson json = new Gson();
        User user = json.fromJson(new InputStreamReader(inpstr), User.class);
        LOG.fine("Put Update json " + user.toString());
        Response response;
        if (userService.getUsers().containsKey(user.getId())) {
            response = Response.noContent().build();
        } else {
            response = Response.created(uriInfo.getAbsolutePath()).build();
        }
        userService.createUser(user);
        LOG.fine(user.toString());
        return response;
    }  
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(InputStream inpstr) {
        Gson json = new Gson();
        User user = json.fromJson(new InputStreamReader(inpstr), User.class);
        LOG.fine("DELETE json " + user.toString());
        userService.deleteUser(id);
    }    
    
    
/*
    @DELETE
    public void deleteUser() {
        LOG.fine("Delete id is " + id);
        userService.deleteUser(id);
    }*/
}
