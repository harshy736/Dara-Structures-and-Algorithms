  
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int nod = 0;
    while(n>0){
        nod++;
        n=n/10;
    }
    System.out.println(nod);
   }
  }
