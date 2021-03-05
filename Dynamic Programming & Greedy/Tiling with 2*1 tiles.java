import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();//length of board - 2 * n board
        
        //for length = 1
        int ver = 1;//end with single tile - vertical
        int lat = 0;//end with 2 tiles - lateral
        
        for(int i = 2; i <= n; i++)
        {
            int total = ver + lat;
            
            //update
            lat = ver;//possible when last one is vertical
            ver = total;//posiible on any type
        }
        
        System.out.println(ver + lat);
    }
}
