import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s = scn.nextLine();
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(')
            {
                st.push(ch);
            }
            else if(ch == ']')
            {
                boolean check = closebracket(st, '[');
                if(check == false)
                {
                    System.out.println(false);
                    return;
                }
            }
            else if(ch == '}')
            {
                boolean check = closebracket(st, '{');
                if(check == false)
                {
                    System.out.println(false);
                    return;
                }
            }
            else if(ch == ')')
            {
                boolean check = closebracket(st, '(');
                if(check == false)
                {
                    System.out.println(false);
                    return;
                }
            }
        }
        
        
        
        if(st.size() == 0)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }
    
    public static boolean closebracket(Stack<Character> st, char op)
    {
        if(st.size() != 0 && st.peek() == op)
        {
            st.pop();
            return true;
        }
        else
        {
            ;return false;
        }
    }

}
