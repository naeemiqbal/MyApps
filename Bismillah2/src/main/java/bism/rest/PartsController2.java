package bism.rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/Parts")
public class PartsController2 {

    static List<Part> mParts;
    static final Logger LOG = Logger.getLogger("Parts");

    public PartsController2() {
        Part p1 = new Part();
        if (mParts == null) {
            mParts = new ArrayList<Part>();
            p1.init();
            mParts.add(p1);
            p1 = new Part();
            p1.init();
            mParts.add(p1);
        }
        p1 = new Part();
        p1.init();
        mParts.add(p1);
    }

    @GET
    public String getAllParts() {
        Gson gson = new Gson();
        LOG.fine("GET ");
        return " { success: true, parts : " + gson.toJson(mParts) + " }";
    }

    @PUT
    public void addPart(Long pId, String pDesc, Date pDate) {        
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        mParts.add(p);
        LOG.fine("PUT Insert");
    }

    @POST
    public void updatePart(Long pId, String pDesc, Date pDate) {        
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        LOG.fine("PUT Insert");
    }

    @DELETE
    public void deletePart(Long pId, String pDesc, Date pDate) {
         Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        mParts.remove(p);
        LOG.fine("PUT Insert");
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
}
