import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if(arr[0] > 0)
        {
            dp[1] = arr[0];
        }
        else
        {
            dp[1] = 0;
        }
        
        for(int i = 2; i <= n; i++)
        {
            int val = arr[i - 1] + dp[i - 2];
            
            if(val > dp[i - 1])//elemnet present produces maximum element
            {
                dp[i] = val;
            }
            else
            {
                dp[i] = dp[i - 1];
            }
        }
        
        
        
        System.out.println(dp[n]);
    }
}
