import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code
    //left border for every column
    int[] lb = new int[n];
    Stack<Integer> lt = new Stack<>();
    
    for(int i = 0; i < a.length; i++)
    {
        while(lt.size() > 0 && a[lt.peek()] >= a[i])
        {
            lt.pop();
        }
        
        if(lt.size() == 0)
        {
            lb[i] = -1;
        }
        else
        {
            lb[i] = lt.peek();
        }
        
        lt.push(i);
    }
    
    //right border
    int[] rb = new int[n];
    Stack<Integer> rt = new Stack<>();
    for(int i = a.length - 1; i >= 0; i--)
    {
        while(rt.size() > 0 && a[rt.peek()] >= a[i])
        {
            rt.pop();
        }
        
        if(rt.size() == 0)
        {
            rb[i] = a.length;
        }
        else
        {
            rb[i] = rt.peek();
        }
        
        rt.push(i);
    }
    
    int maxArea = 0;
    
    for(int i = 0; i < a.length; i++)
    {
        int width = rb[i] - lb[i] - 1;
        int area = width * a[i];
        
        if(maxArea < area)
        {
            maxArea = area;
        }
    }

    
    System.out.println(maxArea);
 }
}
