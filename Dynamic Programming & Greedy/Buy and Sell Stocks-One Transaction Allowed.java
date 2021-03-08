import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] st = new int[n];
        
        for(int i = 0; i < st.length; i++)
        {
            st[i] = scn.nextInt();
        }
        
        //for 1st day
        int least = st[0];
        int profit = 0;
        
        for(int i = 1; i < st.length; i++)
        {
            if(st[i] - least > profit)
            {
                profit = st[i] - least;
            }
            else if(st[i] < least)
            {
                least = st[i]; 
            }
        }
        
        System.out.println(profit);
    }

}
