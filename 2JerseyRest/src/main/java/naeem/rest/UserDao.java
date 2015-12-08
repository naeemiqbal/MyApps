/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naeem.rest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author niqbal
 */
public enum UserDao {

    instance;

    private Map<String, User> users = new HashMap<String, User>();

    UserDao() {
        users.put("1", new User("1", "Naeem", "Greenville"));
        users.put("2", new User("2", "Ahmad", "Calgary"));
        users.put("3", new User("3", "Aamer", "Muscat"));
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
