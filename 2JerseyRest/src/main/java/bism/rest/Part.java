/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bism.rest;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Part {

    @XmlElement
    Long partid;
    @XmlElement
    String partdesc;
    @XmlElement
    Date productiondate;
    @XmlElement
    String id;

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
