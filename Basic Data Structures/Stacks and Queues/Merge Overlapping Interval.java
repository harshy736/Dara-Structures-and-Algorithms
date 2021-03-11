import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        
        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        
        for(int i = 1; i < pairs.length; i++)
        { 
              Pair top = st.peek();

              if(top.et < pairs[i].st)
              {
                  st.push(pairs[i]);
              }
              else
              {
                  top.et = Math.max(top.et, pairs[i].et);
              }
            
        }
        //st in decreasing order 
        
        Stack<Pair> res = new Stack<>();//increasing order
        
        //copy data of st into res but in increasing order
        while(st.size() > 0)
        {
            res.push(st.pop());
        }
        
        //print
        while(res.size() > 0)
        {
            Pair p = res.pop();
            System.out.println(p.st + " " + p.et);
        }
        
    }
    
    
    public static class Pair implements Comparable<Pair>
    {
        int st;
        int et;
        
        Pair(int st, int et)
        {
            this.st = st;
            this.et = et;
        }
        
        //this > other return +ve
        //this == other return 0
        //this < other return -ve
       public int compareTo(Pair p)
       {
           if(this.st != p.st)
           {
               return this.st - p.st;
           }
           else
           {
               return this.et - p.et;
           }
       }
    }

}
