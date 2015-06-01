package bism.rest;

import java.io.Serializable;
import java.util.Date;
//import org.springframework.data.annotation.Id;

class Part implements Serializable{
  
	private static final long serialVersionUID = 1L;
//	@Id
	public Long partid;
	public    String partdesc;
	public Date productiondate;

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