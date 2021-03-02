//KPC -> Mobile Key Pad Combinations

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> words = getKPC(str);
        System.out.print(words);
    }

    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> s = new ArrayList<>();
            s.add("");
            return s;
        }
      
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = getKPC(ros);
        ArrayList<String> mres = new ArrayList<>();
      
        String codesforch = codes[ch-'0'];
        for(int i=0;i<codesforch.length();i++){
            char chcode = codesforch.charAt(i);
            for(String rstr:rres){
                mres.add(chcode + rstr);
            }
        }
        return mres;
    }

}
