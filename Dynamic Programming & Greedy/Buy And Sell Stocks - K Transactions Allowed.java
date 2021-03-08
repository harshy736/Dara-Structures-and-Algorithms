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
        
        int k = scn.nextInt();
        
        int[][] dp = new int[k + 1][n];
        
        //if(d == 0 || t == 0) then dp[t][d] = 0;
        
        for(int t = 1; t < dp.length; t++)
        {
            int pmax = Integer.MIN_VALUE;//iterates in previos row
            for(int d = 1; d < dp[0].length; d++)
            {
                int max = dp[t][d - 1];
                
                if(dp[t - 1][d - 1] - st[d - 1] > pmax)
                {
                    pmax = dp[t - 1][d - 1] - st[d - 1];
                }
                
                int pr = pmax + st[d];
                if(pr > max)
                {
                    max = pr;
                }
                
                dp[t][d] = max;
            }
        }
        
        
        System.out.println(dp[k][n - 1]);
    }

}
