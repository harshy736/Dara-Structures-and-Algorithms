import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();//fences
        int k = scn.nextInt();//colours
        
        //for 1 fence
        int same = 0;//ii
        int diff = k;//ij
        int total = same + diff;//ii + ij
        
        for(int i = 2; i <= n; i++)
        {
            same = diff;
            diff = total * (k - 1);//every color is possible until last one
            
            total = same + diff;
        }
        
        System.out.println(total);
    }
}
