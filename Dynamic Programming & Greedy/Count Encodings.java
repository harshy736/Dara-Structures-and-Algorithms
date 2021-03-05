import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s = scn.nextLine();
        int l = s.length();
        
        int[] dp = new int[l + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= l; i++)
        {
            char ch = s.charAt(i - 1);
            int val = ch - '0';
            
            
            //previous digit
            char pr = s.charAt(i - 2);
            int prval = pr - '0';
            
            if(val == 0)
            {
                if(prval>= 3 || prval <= 0)
                {
                    System.out.println(dp[i]);
                    return;
                }
                else
                {
                    dp[i] = dp[i - 2];
                }
                
            }
            else
            {
               dp[i] = dp[i - 1]; //for single digit
               
               int pos = prval*10 + val;
               if(pos <= 26 && prval != 0)//for double digit
               {
                   dp[i] += dp[i - 2];
               }
            }
            
        }
    
        
        System.out.println(dp[l]);
    }
}
