import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<Character> optrs = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++)
    {
        char ch = exp.charAt(i);
        
        if(ch == '(')
        {
            optrs.push(ch);
        }
        else if(ch == ')')
        {
            while(optrs.peek() != '(')
            {
                char op = optrs.pop();
                String prev2 = pre.pop();
                String prev1 = pre.pop();
                String prev = op + prev1 + prev2;
                pre.push(prev);
                
                String postv2 = post.pop();
                String postv1 = post.pop();
                String postv = postv1 + postv2 + op;
                post.push(postv);
            }
            
            optrs.pop();
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
        {
            while(optrs.size() > 0 && optrs.peek() != '(' && precedence(ch) <= precedence(optrs.peek()))
            {
                char op = optrs.pop();
                String prev2 = pre.pop();
                String prev1 = pre.pop();
                String prev = op + prev1 + prev2;
                pre.push(prev);
                
                String postv2 = post.pop();
                String postv1 = post.pop();
                String postv = postv1 + postv2 + op;
                post.push(postv);
            }
            optrs.push(ch);
        }
        else if(ch != ' ')
        {
            pre.push(ch + "");
            post.push(ch + "");
        }
    }
    
    //if oprts stack some operators left
    while(optrs.size() > 0)
    {
        char op = optrs.pop();
        String prev2 = pre.pop();
        String prev1 = pre.pop();
        String prev = op + prev1 + prev2;
        pre.push(prev);
        
        String postv2 = post.pop();
        String postv1 = post.pop();
        String postv = postv1 + postv2 + op;
        post.push(postv);
    }
    
    System.out.println(post.pop());
    System.out.println(pre.pop());
 }
     
     
 public static int precedence(char op)
 {
     if(op == '+' || op == '-')
     {
         return 1;
     }
     else
     {
         return 2;
     }
 }
     
 
}
