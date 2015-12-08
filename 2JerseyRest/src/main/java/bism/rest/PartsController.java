package bism.rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Parts")
public class PartsController {

    static List<Part> mParts;
    static HashMap<Integer, Long> mMap;
    static final Logger LOG = Logger.getLogger("Parts");

    public PartsController() {
        Part p1 = new Part();
        if (mParts == null) {
            mParts = new ArrayList<Part>();
            mMap = new HashMap();
            p1.init();
            mParts.add(p1);
            mMap.put(mParts.indexOf(p1), p1.partid);
            p1 = new Part();
            p1.init();
            mParts.add(p1);
            mMap.put(mParts.indexOf(p1), p1.partid);
        }
        p1 = new Part();
        p1.init();
        mParts.add(p1);
        mMap.put(mParts.indexOf(p1), p1.partid);
        LOG.setLevel(Level.ALL);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public String getAllParts() {
        Gson gson = new Gson();
        LOG.fine("GET ");
        return " { success: true, parts : " + gson.toJson(mParts) + " }";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPart(final Part input) {
        mParts.add(input);
        mMap.put(mParts.indexOf(input), input.partid);
        LOG.fine(new Date() + " POST Insert\t" + input.toString());
    }

    @Path("/Parts/BISM.model.Part-{recid}")    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePart(final Part p) {
/*        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;*/
        LOG.fine(new Date() + " PUT update\t" + p.toString() + "\trec=" + p.partid);
        if (!mMap.containsKey(p.partid)) {
            mParts.add(p);
            mMap.put(mParts.indexOf(p), p.partid);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePart2(/*final Part p*/) {
        final Part p = new Part();
/*        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;*/
        LOG.fine(new Date() + " PUT update\t" + p.toString() + "\trec=" + p.partid);
        if (!mMap.containsKey(p.partid)) {
            mParts.add(p);
            mMap.put(mParts.indexOf(p), p.partid);
        }
    }
    
    
    /* @Path("/Parts/BISM.model.Part-{recid}")        
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deletePart(@PathParam(value="recid") final String recid) {
        LOG.log(Level.FINE, "Delete '{'0'}' {0}", recid);        
        /*mMap.remove(mParts.indexOf(p));
        mParts.remove(p);}*/

    @Path("/Parts/{recid}")            
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePart2(@PathParam(value="recid")String recid) {
        LOG.log(Level.FINE, "Delete 2");        
    }    
}

