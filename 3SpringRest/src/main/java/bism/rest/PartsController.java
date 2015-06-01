package bism.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("rest/Parts")
public class PartsController {

    static List<Part> mParts;
    static HashMap<Integer, Long> mMap;
    final Logger LOG = Logger.getLogger(getClass().getName());

    public PartsController() {
        Part p1 = new Part();
        if (mParts == null) {
            mParts = new ArrayList<Part>();
            mMap = new HashMap<Integer, Long>();
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

    @RequestMapping( method= RequestMethod.GET)
    public List<Part> getAllParts() {
    	LOG.log(Level.INFO, "GET request");
    	return mParts;
    }

    @RequestMapping(method=RequestMethod.PUT)
    public void addPart(@RequestParam("partid") Long pId, @RequestParam("partdesc") String pDesc, @RequestParam("productiondate") Date pDate) {
    	LOG.log(Level.INFO, "PUT request");    	
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        mParts.add(p);
        mMap.put(mParts.indexOf(p), p.partid);
        LOG.fine(new Date() + " POST Insert\t" + p.toString());
    }

    @RequestMapping(method=RequestMethod.POST)
    public void updatePart(@RequestParam("partid") Long pId, @RequestParam("partdesc") String pDesc,
            @RequestParam("productiondate") Date pDate, @RequestParam("param1") int recId) {
    	LOG.log(Level.INFO, "POST request");    	
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        LOG.fine(new Date() + " PUT update\t" + p.toString() + "\trec=" + recId);
        if (recId > 0) {
            mParts.add(recId, p);
        }
    }

    public void deletePart(@RequestParam("partid") Long pId, @RequestParam("partdesc") String pDesc, @RequestParam("productiondate") Date pDate) {
        Part p = new Part();
        p.partid = pId;
        p.partdesc = pDesc;
        p.productiondate = pDate;
        mMap.remove(mParts.indexOf(p));
        mParts.remove(p);
        LOG.fine("Delete ");
    }
}
