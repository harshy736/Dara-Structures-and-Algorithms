import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int d = 3;
    
    while(n > 1){
        if(n%2 == 0){
            System.out.print(2 + " ");
            n /= 2;
        }else{
            break;
        }
    }
    
    while(n > 1){
        if(n%d == 0){
            System.out.print(d + " ");
            n /= d;
        }else{
            d += 2;
        }
    }
 }
}
