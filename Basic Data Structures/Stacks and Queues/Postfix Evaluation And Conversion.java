import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<Integer> vs = new Stack<>();
    Stack<String> inf = new Stack<>();
    Stack<String> pre = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++)
    {
        char ch = exp.charAt(i);
        
        
        if(Character.isDigit(ch))
        {
            vs.push(ch - '0');//char to int
            inf.push(ch + "");
            pre.push(ch + "");
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
        {
            int v2 = vs.pop();
            int v1 = vs.pop();
            
            int res = operation(ch, v1, v2);
            vs.push(res);
            
            //infinix
            String inv2 = inf.pop();
            String inv1 = inf.pop();
            
            String infv = '(' + inv1 + ch + inv2 + ')';
            inf.push(infv);
            
            //prefix
            String prev2 = pre.pop();
            String prev1 = pre.pop();
            
            String inv = ch + prev1 + prev2;
            pre.push(inv);
        }
    }
        
        //if oprts stack some operators left
        
        
        System.out.println(vs.pop());
        System.out.println(inf.pop());
        System.out.println(pre.pop());
}
     
     
     
 public static int operation(char op, int v1, int v2)
 {
     if(op == '+')
     {
         return v1 + v2;
     }
     else if(op == '-')
     {
         return v1 - v2;
     }
     else if(op == '*')
     {
         return v1 * v2;
     }
     else
     {
         return v1 / v2;
     }

 }

}
