/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naeem.learn;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author niqbal
 */
@WebServlet(name = "UsersController", urlPatterns = {"/servlets/Users"})
public class UsersController extends HttpServlet {

    static final Logger LOGGER = Logger.getLogger("UsersController");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        String op = request.getParameter("op");
        op = op == null ? "READ" : op;
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            BufferedReader rdr = request.getReader();
            switch (op) {
                case "CREATE": {
                    //Result rslt = gson.fromJson(rdr, Result.class);
                    Results.User rslt = gson.fromJson(rdr, Results.User.class);
                    LOGGER.info(op + " Input " + rslt);
                    break;
                }
                case "UPDATE": {
                    //Result rslt = gson.fromJson(rdr, Result.class);
                    //Result.User[] rslt = gson.fromJson(rdr, Result.User[].class);
                    //Result.User rslt = gson.fromJson(rdr, Result.User.class);
                    Results rslt = gson.fromJson(rdr, Results.class);
                    LOGGER.info(op + " Input " + rslt);
                    break;
                }
                case "DELETE": {
                    Results rslt = parseResult(rdr);
//                        Results rslt = gson.fromJson(rdr, Results.class);
                    // Results.User[] rslt = gson.fromJson(rdr, Results.User[].class);
                    //Result.User rslt = gson.fromJson(rdr, Result.User.class);
                    //LOGGER.info(op + " Input " + rslt);
                    JsonReader jrdr = Json.createReader(rdr);
                    JsonObject obj = jrdr.readObject();
                    //JsonArray arr = obj.getJsonArray("results");
                    Object arr = obj.getJsonObject("results");
                    if (arr instanceof JsonObject) {
                        Results.User usr = (Results.User) arr;
                        LOGGER.fine("its object " + arr + usr);
                    } else if (arr instanceof JsonArray) {
                        LOGGER.fine("its array " + arr);
                    }

                    /*for ( Results.User usr : arr.getValuesAs(Results.User.class)){
                     for (JsonObject result : arr.getValuesAs(JsonObject.class)) {    
                     LOGGER.info(op + " Input " + result );                            
                     }*/
                    break;
                }
                //if (  "READ".equals(op))
                default:
                    Results rslt = new Results();
                    rslt.setResults( UsersDAO.instance.getUsers2());
                    out.print(gson.toJson(rslt));
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    Results parseResult(BufferedReader rdr) {
        Results rslt = new Results();
        try {
            StringBuffer str = new StringBuffer();
            String line;
            while ((line = rdr.readLine()) != null) {
                str.append(line);
            }
            LOGGER.fine(line);
            //int start, end;
            String label = "";
            final char start = '{', colon = ':', end = '}';

            char[] str2 = line.toCharArray();
            for (char c : str2) {
                if (c == start) {
                } else if (c == colon) {
                } else {
                    label += c;
                }

            }

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return rslt;
    }
}

class Results {

    ArrayList<User> results;

    public ArrayList<User> getResults() {
        return results;
    }

    public void setResults(ArrayList<User> rslt) {
        this.results = rslt;
    }

    class User {

        private int id;
        private String name;
        private String location;

        public User(int id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
            return "\nId=" + this.id + "\tName=" + this.name + "\tLocation=" + this.location;
        }

    }
}

enum UsersDAO {
    instance;
    private List<Results.User> users = new LinkedList<Results.User>();

    UsersDAO() {
        Results results = new Results();
        users.add(results.new User(1, "Naeem 1105", "Greenville"));
        users.add(results.new User(2, "Ahmad", "Calgary"));
        users.add(results.new User(3, "Aamer", "Muscat"));
    }

    public List<Results.User> getUsers() {
        return users;
    }
    public ArrayList<Results.User> getUsers2() {
        return new ArrayList(users);
    }    
}
