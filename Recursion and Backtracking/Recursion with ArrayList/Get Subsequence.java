import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> s = gss(str);
        System.out.print(s);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            ArrayList<String> b = new ArrayList<>();
            b.add("");
            return b;
        }
      
        char ch = str.charAt(0);
        String sr = str.substring(1);
        ArrayList<String> ss = gss(sr);
        ArrayList<String> s = new ArrayList<>();
        for(String r:ss){
            s.add("" + r);
        }
        for(String r:ss){
            s.add(ch + r);
        }
        return s;
    }

}
