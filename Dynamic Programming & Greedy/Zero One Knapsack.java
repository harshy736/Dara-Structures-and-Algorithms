import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] val = new int[n];
        int[] wgt = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            val[i] = scn.nextInt();
        }
        
        for(int i = 0; i < n; i++)
        {
            wgt[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        int[][] dp = new int[n + 1][cap + 1];
        
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[0].length; j++)
            {
                if(i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    int c = wgt[i - 1];
                    if(c <= j)
                    {
                        int nc = val[i - 1] + dp[i - 1][j - c];
                        if(nc >= dp[i - 1][j])
                        {
                            dp[i][j] = nc;
                        }
                        else
                        {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                    else
                    {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        
        System.out.println(dp[n][cap]);
    }
}
