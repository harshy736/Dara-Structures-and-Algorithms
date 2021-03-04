import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] jmp = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            jmp[i] = scn.nextInt();
        }
        
        int minMoves = moves(n, jmp);
        
        System.out.println(minMoves);
    }
    
    
    public static int moves(int n, int[] jmp)
    {
        Integer[] dp = new Integer[n + 1];
        
        dp[n] = 0;//
        
        for(int i = n - 1; i >= 0; i--)
        {
            if(jmp[i] > 0)
            {
                int mm = Integer.MAX_VALUE;
                for(int j = 1; j <= jmp[i] && i + j <= n; j++)
                {
                    if(dp[i+j] != null)
                    {
                        mm = Math.min(mm, dp[i+j]);
                    }
                }
                
                
                if(mm != Integer.MAX_VALUE)
                {
                    dp[i] = mm + 1;
                }
                else
                {
                    dp[i] = null;
                }
            }
        }
        return dp[0];
    }

}
