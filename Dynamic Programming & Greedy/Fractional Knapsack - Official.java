import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] val = new int[n];
        int[] wgt = new int[n];
        
        for(int i = 0; i < n; i++){
            val[i] = scn.nextInt();
        }
        
        for(int i = 0; i < n; i++){
            wgt[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        float[][] dp = new float[n + 1][cap + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    int c = wgt[i - 1];
                    if(c <= j)
                    {
                        dp[i][j] = dp[i-1][j];
                        float par = val[i - 1] / (float)c ;
                        for(int k = c; k >= 1; k--){
                            float nc = par*k + dp[i - 1][j - k];
                            if(nc >= dp[i][j]){
                                dp[i][j] = nc;
                            }
                        }
                    }
                    else
                    {
                        float par = val[i - 1] / (float)c ;
                        float nv = par + dp[i][j - 1];
                        if(nv > dp[i - 1][j]){
                            dp[i][j] = nv;
                        }
                        else{
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }
        
        
        
        float res = dp[n][cap];
        
        System.out.println(res);
    }
}
