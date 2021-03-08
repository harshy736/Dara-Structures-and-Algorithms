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
        
        //atmost 2 transactions
        
        //for 1st transaction
        int[] tr1 = new int[n];//stores max profit on 1st transaction 
        tr1[0] = 0;//on 1st day
        int least = st[0];//assume buy on first day
        
        for(int d = 1; d < st.length; d++)
        {
            if(st[d] <= least)
            {
                least = st[d];
                tr1[d] = tr1[d - 1];
            }
            else
            {
                int pr = st[d] - least;
                if(pr > tr1[d - 1])//selling stock on this day makes more profit
                {
                    tr1[d] = pr;
                }
                else//if we sell stock on previous day makes more profit than today
                {
                    tr1[d] = tr1[d - 1];
                }
            }
        }
        
        //for 2nd transaction - start from back
        int[] tr2 = new int[n];//stores max profit on 2nd transaction 
        tr2[n - 1] = 0;//on last day - 
        int max = st[n - 1];//selling price - max after ith day
        
        for(int d = n - 2; d >= 0; d--)
        {
            if(st[d] >= max)//profit -> negative
            {
                max = st[d];
                tr2[d] = tr2[d + 1];
            }
            else
            {
                int pr = max - st[d];
                if(pr > tr2[d + 1])//buying stock on this day makes more profit
                {
                    tr2[d] = pr;
                }
                else//
                {
                    tr2[d] = tr2[d + 1];
                }
            }
        }
        
        //now find the day on which max profit 
        int profit = 0;
        for(int d = 0; d < n; d++)
        {
            if(tr1[d] + tr2[d] > profit)
            {
                profit = tr1[d] + tr2[d];
            }
        }
        
        
        
        System.out.println(profit);
    }

}
