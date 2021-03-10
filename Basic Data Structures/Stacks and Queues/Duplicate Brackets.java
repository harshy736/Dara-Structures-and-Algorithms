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
            if(ch != ')')
            {
                st.push(ch);
            }
            else
            {
                if(st.peek() == '(' )//no material inside bracket - duplicate
                {
                    System.out.println(true);
                    return;
                }
                else
                {
                    while(st.peek() != '(' )
                    {
                        st.pop();
                    }
                    st.pop();
                }
            }
        }
        
        System.out.println(false);
    }

}
