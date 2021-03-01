import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int p = power(x,n);
        System.out.print(p);
    }

    public static int power(int x, int n){
        
        if(x==1 || n==0){
            return 1;
        }else{
          int ans1 = power(n/2);
          int ans = ans1*ans1;
          
          if(n%2!=0){
              ans *= x;
          }
          
          return ans;
        }
    }

}
