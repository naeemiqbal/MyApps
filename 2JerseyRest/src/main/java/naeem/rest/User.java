/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naeem.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author niqbal
 */
@XmlRootElement
public class User {

    private String id;
    private String name;
    private String location;

    public User() {
    }

    public User(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "\nID=" + id + "\tName=" + name + "\tLocation=" + location;
    }
}
