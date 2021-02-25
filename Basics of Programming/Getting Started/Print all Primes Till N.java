import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
      
        for(int i = low; i <= high; i++){
            boolean isPrime = true;
          
            for(int d=2; d*d< = i; d++){
                if(i%k==0){
                    isPrime = false;
                    break;
                }
            }
          
            if(isPrime){
                System.out.println(i);
            }
        }
    }
}
