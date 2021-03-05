import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[][] paint = new int[n][3];//3 rows for red, blue, green
        //cols - home
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < paint[0].length; j++)
            {
                paint[i][j] = scn.nextInt();
            }
        }
        
        //paint act as dp array well
        
        for(int i = 1; i < n; i++)
        {
            paint[i][0] += Math.min(paint[i - 1][1], paint[i - 1][2]);//red
            paint[i][1] += Math.min(paint[i - 1][0], paint[i - 1][2]);//blue
            paint[i][2] += Math.min(paint[i - 1][0], paint[i - 1][1]);//green
        }
        
        int cost = Math.min(paint[n - 1][0], Math.min(paint[n - 1][1], paint[n - 1][2]));//minimum cost fo n houses
        
        System.out.println(cost);
    }
}
