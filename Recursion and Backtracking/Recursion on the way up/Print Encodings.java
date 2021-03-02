/*
1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed. In this case print nothing.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str,"");
    }
  
    public static void printEncodings(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        else if(str.length()==1){
            char ch = str.charAt(0);
            if(ch=='0'){
                return;
            }
            int chv = ch - '0';
            char code = (char)('a'+chv-1);
            ans+=code;
            System.out.println(ans);
        }
        else{
            char a = str.charAt(0);
            String s1 = str.substring(1);
            if(a=='0'){
                return;
            }
            else{
                int chv = a - '0';
                char code = (char)('a'+chv-1);
                printEncodings(s1,ans+code);
            }
            String sa = str.substring(0,2);
            String s2 = str.substring(2);
            int c = Integer.parseInt(sa);
            if(c<=26){
                char code2 = (char)('a'+c-1);
                printEncodings(s2,ans+code2);
            }
            else{
                return;
            }
        }
    }
}
