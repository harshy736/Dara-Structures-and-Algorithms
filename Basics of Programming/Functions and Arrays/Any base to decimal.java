import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      int sum=0,p=1;
      while(n>0){
          sum+=(n%10)*p;
          p *= b;
          n /= 10;
      }
      return sum;
   }
  }
