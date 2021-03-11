import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> cel = new Stack<>();
        
        for(int i = 0; i < arr.length; i++)//every people pushed into stack
        {
            cel.push(i);
              
        }
        
        //check on 2 peoples  -> one is sure not a celeb , eliminate 
        while(cel.size() > 1)//1 may be celebrity
        {
            int p1 = cel.pop();
            int p2 = cel.pop();
            
            if(arr[p1][p2] == 1)//p1 knows p2 -> p1 not a celebrity
            {
                cel.push(p2);//p2 may be cel
            }
            else//p1 dont konw p2 -> p2 is not a celebrity 
            {
                cel.push(p1);//p1 may be celeb
            }
        }
        
        //one people left in stack after eliminating n - 1 people who are not celebrity
        //check for last person if he is celeb or not
        
        boolean celeb = true;//assume celeb
        int p = cel.pop();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[p][i] == 1)//person p knows someone
            {
                celeb = false;
                break;
            }
            else if(arr[i][p] == 0 && p != i)//everyonr doesn't know about p
            {
                celeb = false;
                break;
            }
        }
        
        
        if(celeb == true)
        {
            System.out.println(p);
        }
        else
        {
            System.out.println("none");
        }
        
    }

}
