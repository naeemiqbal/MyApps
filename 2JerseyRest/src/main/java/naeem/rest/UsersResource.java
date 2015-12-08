package naeem.rest;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UsersResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    UserService userService;

    public UsersResource() {
        userService = new UserService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userService.getUserAsList();
    }
/*
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<User> getUsersAsHtml() {
        return userService.getUserAsList();
    }*/

    // URI: /rest/users/count
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        return String.valueOf(userService.getUsersCount());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(InputStream inpstr) {
        Gson json = new Gson();
        User user = json.fromJson(new InputStreamReader(inpstr), User.class);
        userService.createUser(user);
    }

    @Path("{user}")
    public UserResource getUser(@PathParam("user") String id) {
        return new UserResource(uriInfo, request, id);
    }
}
