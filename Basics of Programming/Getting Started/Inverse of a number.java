import java.util.*;

public class Main{

    public static void main(String[] args) {
          // write your code here 
          Scanner scn = new Scanner(System.in);
          int n = scn.nextInt();
          
          int inv = 0, p = 1;
          
          while(n > 0){
              int pv = n%10;
              n /= 10;
              
              inv += p * (int)Math.pow(10, pv - 1);
              p++;
          }
          
          System.out.println(inv);
     }
}
