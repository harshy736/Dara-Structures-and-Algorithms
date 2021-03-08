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
        
        //initial - trading
        int obsp = -st[0];//bought state - we have stock to sell, money which we have shows by bsp, -ve means debit on us, try to maximize 
        //bsp - one extra stock to sell
        int ossp = 0;//sold state - no stock left, money after selling stock, maximize
        //ssp - oppurtinity to buy
        int ocsp = 0;//cold down state
        
        for(int i = 1; i < st.length; i++)
        {
            int nbsp = ocsp - st[i];
            int nssp = obsp + st[i];
            int ncsp = ossp;
            
            if(nbsp > obsp)
            {
                obsp = nbsp;
            }
            
            if(nssp > ossp)//change when sold at profit
            {
                ossp = nssp;
            }
            
            if(ncsp > ocsp)//only change when cooldown happen
            {
                ocsp = ncsp;
            }
        }
        
        
        
        System.out.println(ossp);
    }
    
}
