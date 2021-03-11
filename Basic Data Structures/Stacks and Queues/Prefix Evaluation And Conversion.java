import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<Integer> vs = new Stack<>();
    Stack<String> inf = new Stack<>();
    Stack<String> post = new Stack<>();
    
    for(int i = exp.length() - 1; i >= 0; i--)
    {
        char ch = exp.charAt(i);
        
        
        if(Character.isDigit(ch))
        {
            vs.push(ch - '0');//char to int
            inf.push(ch + "");
            post.push(ch + "");
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
        {
            int v1 = vs.pop();
            int v2 = vs.pop();
            
            int res = operation(ch, v1, v2);
            vs.push(res);
            
            //infinix
            String inv1 = inf.pop();
            String inv2 = inf.pop();
            
            String infv = '(' + inv1 + ch + inv2 + ')';
            inf.push(infv);
            
            //prefix
            String postv1 = post.pop();
            String postv2 = post.pop();
            
            String postv = postv1 + postv2 + ch;
            post.push(postv);
        }
    }
        
    //if oprts stack some operators left
    
    
    System.out.println(vs.pop());
    System.out.println(inf.pop());
    System.out.println(post.pop());
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
