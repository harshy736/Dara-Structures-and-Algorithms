import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();//length
        int m = scn.nextInt();//breadth
        
        //Board - n * m
        //Tile - m * 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        //lateral will possible only if length >= length of tile
        
        for(int i = 1; i <= n; i++)
        {
            if(i < m)
            {
                dp[i] = 1;
            }
            else if(i == m)
            {
                dp[i] = 2;
            }
            else
            {
                dp[i] = dp[i - 1] + dp[i - m];//vertical and lateral respectively
            }
        }
        
        
        System.out.println(dp[n]);
    }
}
