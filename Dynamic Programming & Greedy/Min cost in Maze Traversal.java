import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] maze = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int  j = 0; j < m; j++)
            {
                maze[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][m];
        
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = m - 1; j >= 0; j--)
            {
                if(j == m - 1 && i == n - 1)
                {
                    dp[i][j] = maze[i][j];
                }
                else if(i == n - 1)
                {
                    dp[i][j] = dp[i][j + 1] + maze[i][j];
                }
                else if(j == m - 1)
                {
                    dp[i][j] = dp[i + 1][j] + maze[i][j];
                }
                else
                {
                    int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = maze[i][j] + min;
                }
            }
        }
        
        System.out.println(dp[0][0]);
    }

}
