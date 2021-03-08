import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] st = new int[n];
        
        for(int i = 0; i < st.length; i++)
        {
            st[i] = scn.nextInt();
        }
        
        int profit = 0;
        
        for(int i = 0; i < st.length - 1; i++)
        {
            if(st[i + 1] > st[i])
            {
                profit += st[i + 1] - st[i];
            }
        }
        
        
        System.out.println(profit);
    }

}
