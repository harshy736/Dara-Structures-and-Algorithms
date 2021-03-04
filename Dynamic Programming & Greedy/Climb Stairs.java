import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] qb = new int[n + 1];
        
        
        
        int nways = stairs(0, n,  qb);
        
        System.out.println(nways);
    }
    
    
    public static int stairs(int p, int n, int[] qb)
    {
        //base
        if(p == n){
            return 1;
        }
        else if(p > n)
        {
            return 0;
        }
        
        
        if(qb[p] != 0)
        {
            return qb[p];
        }
        
        int j1st = stairs(p + 1, n, qb);
        int j2st = stairs(p + 2, n, qb);
        int j3st = stairs(p + 3, n, qb);
        int nways = j1st + j2st + j3st;
        
        qb[p] = nways;
        
        return nways;
    }

}
