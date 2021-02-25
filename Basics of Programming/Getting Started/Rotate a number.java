import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here
     Scanner scn = new Scanner(System.in);
     
     int n = scn.nextInt(), k = scn.nextInt();
     
     int nod = 0, temp = n;
     while(temp > 0){
         nod++;
         temp /= 10;
     }
     
     if(k >= nod || k <= -nod){
         k %= nod;
     }
     
     if(k < 0){
         k += nod;
     }
     
     
     int rpw = (int)Math.pow(10, k);
     int rp = n%rpw;
     n /= rpw;
     
     int r = rp*(int)Math.pow(10, nod - k) + n;
     
     System.out.println(r);
    }
   }
