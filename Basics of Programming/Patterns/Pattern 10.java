import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int s1=n/2,s2=0;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=s1;j++){
            System.out.print("\t");
        }
        System.out.print("*");
        
        
        for(int j=1;j<=s2;j++){
            System.out.print("\t");
        }
           
        if(i > 0 && i < n - 1){
          System.out.print("*");
        }
        
        if(i<=n/2){
            s1--;
            s2+=2;
        }
        else{
            s1++;
            s2-=2;
        }
        System.out.println();
    }
 }
}
