import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] gold = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int  j = 0; j < m; j++)
            {
                gold[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][m];
        
        for(int j = m - 1; j >= 0; j--)
        {
            for(int i = 0; i < n; i++)
            {
                if(j == m - 1)
                {
                    dp[i][j] = gold[i][j];
                }
                else if(i == 0)
                {
                    dp[i][j] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]) + gold[i][j];
                }
                else if(i == n - 1)
                {
                    dp[i][j] = Math.max(dp[i - 1][j + 1], dp[i][j + 1]) + gold[i][j];
                }
                else
                {
                    int mg = Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                    mg = Math.max(mg, dp[i + 1][j + 1]);
                    dp[i][j] = gold[i][j] + mg;
                }
            }
        }
        
        int max_gold = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            if(dp[i][0] > max_gold)
            {
                max_gold = dp[i][0];
            }
        }
        
        
        System.out.println(max_gold);
    }

}
