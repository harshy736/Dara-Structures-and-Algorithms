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
            
            int[] dp = new int[cap + 1];
            dp[0] = 0;
            
            for(int j = 1; j < dp.length; j++)
            {
                for(int i = 0; i < wgt.length; i++)
                {
                    int w = wgt[i];
                    if(w <= j)
                    {
                        int nc = val[i] + dp[j - w];
                        if(nc > dp[j])
                        {
                            dp[j] = nc;
                        }
                    }
                }
            }
            
            System.out.println(dp[cap]);
        
	    }
	}
