import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        Stack<Integer> opnds = new Stack<>();
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
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();
                    
                    int res = operation(op, v1, v2);
                    opnds.push(res);
                }
                
                optrs.pop();
            }
            else if(Character.isDigit(ch))
            {
                opnds.push(ch - '0');//char to int
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while(optrs.size() > 0 && optrs.peek() != '(' && precedence(ch) <= precedence(optrs.peek()))
                {
                    char op = optrs.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();
                    
                    int res = operation(op, v1, v2);
                    opnds.push(res);
                }
                optrs.push(ch);
            }
        }
        
        //if oprts stack some operators left
        while(optrs.size() > 0)
        {
            char op = optrs.pop();
            int v2 = opnds.pop();
            int v1 = opnds.pop();
            
            int res = operation(op, v1, v2);
            opnds.push(res);
        }
        
        System.out.println(opnds.pop());
     }
     
     
     public static int precedence(char op)
     {
         if(op == '+')
         {
             return 1;
         }
         else if(op == '-')
         {
             return 1;
         }
         else if(op == '*')
         {
             return 2;
         }
         else
         {
             return 2;
         }
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
