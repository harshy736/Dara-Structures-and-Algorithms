import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long[][] paint = new long[n][k];//3 rows for red, blue, green
        //cols - home
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < paint[0].length; j++)
            {
                paint[i][j] = scn.nextInt();
            }
        }
        
        //dp array 
        long[][] dp = new long[n][k];
        
        long least = Integer.MAX_VALUE;//stores minimum of a row
        long second = Integer.MAX_VALUE;//stores second minimum of row
        
        for(int j = 0; j < dp[0].length; j++)//1st row same as paint
        {
            dp[0][j] = paint[0][j];
            
            if(dp[0][j] < least)
            {
                second = least;
                least = dp[0][j];
                
            }
            else if(dp[0][j] < second)
            {
                second = dp[0][j];
            }
        }
        
        for(int i = 1; i < n; i++)
        {
            long nleast = Integer.MAX_VALUE;//stores minimum of a row
            long nsecond = Integer.MAX_VALUE;
        
           for(int j = 0; j < paint[0].length; j++)
           {
               if(dp[i - 1][j] == least)//equals to least
               {
                   dp[i][j] = paint[i][j] + second;
               }
               else
               {
                   dp[i][j] = paint[i][j] + least;
               }
               
               //find least, second minimum
               if(dp[i][j] < nleast)
                {
                    nsecond = nleast;
                    nleast = dp[i][j];
                }
                else if(dp[i][j] < nsecond)
                {
                    nsecond = dp[i][j];
                }
           }
           
           //upadte 
           least = nleast;
           second = nsecond;
        }
        
        long cost = Integer.MAX_VALUE;//minimum cost fo n houses
        
        for(int j = 0; j < paint[0].length; j++)
        {
            if(paint[n - 1][j] < cost)
            {
                cost = paint[n - 1][j];
            }
        }
        
        
        System.out.println(least);
    }
    

}
