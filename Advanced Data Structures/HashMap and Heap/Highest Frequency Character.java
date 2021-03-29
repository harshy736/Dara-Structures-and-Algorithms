import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(hm.containsKey(ch) == true){
                int pf = hm.get(ch);
                int nf = pf + 1;
                hm.put(ch, pf + 1);
            }else{
                hm.put(ch, 1);
            }
        }
        
        char maxf = str.charAt(0);
        for(Character key : hm.keySet()){
            if(hm.get(key) > hm.get(maxf)){
                maxf = key;
            }
        }
        
        System.out.println(maxf);
    }

}
