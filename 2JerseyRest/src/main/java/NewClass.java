
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NewClass {

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        ArrayList<Integer> nums = getNumbers(input);
        int dif1, dif2, missednum, num1, num2;
        boolean found = false;
        //while(found)    
        for (int i = 1; i < nums.size() - 1; i++) {
            dif1 = nums.get(i) + nums.get(i + 1);
            dif2 = nums.get(i + 1) + nums.get(i + 2);
        }

    }

    static ArrayList<Integer> getNumbers(String pStr) {
        ArrayList<Integer> vReturn = new ArrayList();
        if (pStr != null) {
            StringTokenizer str = new StringTokenizer(pStr, " ");
            while (str.hasMoreTokens()) {
                vReturn.add(Integer.parseInt(str.nextToken()));
            }
        }
        return vReturn;
    }
}
