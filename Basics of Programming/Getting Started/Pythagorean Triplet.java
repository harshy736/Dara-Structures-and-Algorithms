import java.util.*;
  
public class Main{

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
      int a = scn.nextInt();
      int b = scn.nextInt();
      int c = scn.nextInt();
    
      // c is largest
      if(c < b){
          //swap
          c = c + b;
          b = c - b;
          c = c - b;
      }
      
      if(c < a){
          //swap
          c = c + a;
          a = c - a;
          c = c - a;
      }
      
      if(c*c == a*a + b*b){
          System.out.print("true");
      }
      else{
          System.out.print("false");
      }
   }
}
