import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    
    int co0 = 1;//for length 1
    int co1 = 1;//for length 1
    
    if(n <= 0)
    {
        System.out.println('0');
    }
    
    for(int i = 2; i <= n; i++)
    {
        int cn0 = co1;
        int cn1 = co0 + co1;
        
        //update
        co0 = cn0;
        co1 = cn1;
    }
    
    System.out.println(co0 + co1);
 }

}
