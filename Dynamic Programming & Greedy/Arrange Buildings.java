import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    long n = scn.nextInt();//length of road
    
    long opnb = 1;//not build length = 1, end with no building at last
    long opb = 1;//build, building at last
    
    if(n <= 0)
    {
        System.out.println('0');
        return;
    }
    
    for(int i = 2; i <= n; i++)
    {
        long npnb = opb;
        long npb = opnb + opb;
        
        //update
        opnb = npnb;
        opb = npb;
    }
    
    long b1side = opnb + opb;//no. of ways in 1 side
    
    long total = b1side * b1side;//total no. of ways on 2 sides
    
    System.out.println(total);
 }

}
