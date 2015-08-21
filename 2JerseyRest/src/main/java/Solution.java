
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {

    static final String DELIMITER = " ";

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution sol = new Solution();
        sol.run();
    }

    void run() {
        try {
            HashSet<String> OpsToDo = new HashSet(); // Set to operations to perform.             
            /* Read input operations*/
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String input = read.readLine();
            StringTokenizer str = new StringTokenizer(input, DELIMITER);
            while (str.hasMoreTokens()) {
                OpsToDo.add(str.nextToken());
            }
            String op; // Operation to perform
            Iterator<String> iter = OpsToDo.iterator();
            while (iter.hasNext()) {
                op = iter.next();
                runTask(op); //Perform operation
            }
        } catch (IOException ex) {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*This method perform the task. If the method is defined it is run otherwise gives an error */
    private void runTask(String task){

        try {
            boolean taskran = false;
            Class c = this.getClass();
            Object t = c.newInstance();
            Method[] methods = c.getDeclaredMethods();
            String name;
            for (Method m : methods) {
                if (task.equalsIgnoreCase(m.getName())) {
                  taskran = true; 
                  m.invoke(t);
                }
            }
            if (!taskran )
                 Logger.getLogger(Solution.class.getName()).log(Level.WARNING,"The input task not found. Defined task at this facility are Paint, Inspect, Package ");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* Defined Tasks*/    
    void Paint() {
        System.out.println("The product painted");
    }
    void Inspect() {
        System.out.println("The product inspected");
    }
    void Package() {
        System.out.println("The product packed");
    }
}
