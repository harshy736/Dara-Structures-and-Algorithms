import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] st = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            st[i] = scn.nextInt();
        }
        
        int fee = scn.nextInt();
        
        //initial - trading
        int bsp = -st[0];//bought state - we have stock to sell, money which we have shows by bsp, -ve means debit on us, try to maximize 
        //bsp - one extra stock to sell
        int ssp = 0;//sold state - no stock left, money after selling stock, maximize
        //ssp - oppurtinity to buy
        
        for(int i = 1; i < st.length; i++)
        {
            int nbsp = ssp - st[i];//buy stock on ith day
            int nssp = bsp + st[i] - fee;//sell stock on ith day
            
            if(nbsp > bsp)
            {
                bsp = nbsp;
            }
            
            if(nssp > ssp)
            {
                ssp = nssp;
            }
        }
        
        System.out.println(ssp);
    }

}
