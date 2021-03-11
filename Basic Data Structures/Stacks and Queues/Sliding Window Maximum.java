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
    int k = Integer.parseInt(br.readLine());

    // code
    int[] gri = new int[a.length];//greater elemnent on right index
    Stack<Integer> st = new Stack<>();
   
   
   //find greater index on right (of indexes) 
    for(int i = a.length - 1; i >= 0; i--)
    {
        while(st.size() > 0 && a[i] >= a[st.peek()])
        {
            st.pop();
        }
        
        if(st.size() == 0)
        {
            gri[i] = a.length;
        }
        else
        {
            gri[i] = st.peek();
        }
        st.push(i);
    }
    
    
    for(int i = 0; i <= a.length - k; i++)
    {
        int j = i;
        while(gri[j] < i + k)
        {
            j = gri[j];
        }
        
        System.out.println(a[j]);
    }
    
    //output
    
 }
}
