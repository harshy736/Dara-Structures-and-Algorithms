import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] coins = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            coins[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        
        for(int i = 0; i < coins.length; i++)
        {
            int c = coins[i];
            
            for(int j = c; j < dp.length; j++)
            {
                dp[j] += dp[j - c];
            }
        }
        
        
        System.out.println(dp[amt]);
    }
}
