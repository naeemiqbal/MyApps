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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/Parts")
public class PartsController2 {

    static List<Part> mParts;
    static HashMap<Integer, Long> mMap;
    static final Logger LOG = Logger.getLogger("Parts");

    public PartsController2() {
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
    //@Produces(MediaType.APPLICATION_JSON)    
    public String getAllParts() {
        Gson gson = new Gson();
        LOG.fine("GET ");
        return " { success: true, parts : " + gson.toJson(mParts) + " }";
    }

    //  @Path("/BISM.model.Part-{param1}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPart(@FormParam("partid") Long pId, @FormParam("partdesc") String pDesc, @FormParam("productiondate") Date pDate) {
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        mParts.add(p);
        mMap.put(mParts.indexOf(p), p.partid);
        LOG.fine(new Date() + " POST Insert\t" + p.toString());
    }

    @PUT
//    @Path("/BISM.model.Part-{param1}"  )
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePart(@FormParam("partid") Long pId, @FormParam("partdesc") String pDesc,
            @FormParam("productiondate") Date pDate, @PathParam("param1") int recId) {
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        LOG.fine(new Date() + " PUT update\t" + p.toString() + "\trec=" + recId);
        if (recId > 0) {
            mParts.add(recId, p);
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePart(@FormParam("partid") Long pId, @FormParam("partdesc") String pDesc, @FormParam("productiondate") Date pDate) {
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        mMap.remove(mParts.indexOf(p));
        mParts.remove(p);
        LOG.fine("Delete ");
    }
}

class Part {
    Long partid;
    String partdesc;
    Date productiondate;

    public void init() {
        Date d = new Date();
        this.partid = d.getTime();
        this.productiondate = d;
        this.partdesc = d.toString();
    }

    @Override
    public String toString() {
        return partid + "\t" + partdesc + "\t" + productiondate;
    }
}
