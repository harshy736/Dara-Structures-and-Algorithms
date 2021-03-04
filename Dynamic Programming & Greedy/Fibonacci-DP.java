import java.io.*;
import java.util.*;

public class Main{

  public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int ans = fabonaccimemoized(n, new int[n+1]);
      System.out.print(ans);
  }

  public static int fabonaccimemoized(int n, int[] qb){
      if(n==0 || n==1){
          return n;
      }
      if(qb[n] != 0){
        return qb[n];
      }
    
      int x1 = fabonaccimemoized(n-1, qb);
      int x2 = fabonaccimemoized(n-2, qb);
      int ans = x1 + x2;
    
      qb[n] = ans;
      return ans;
  }
}
