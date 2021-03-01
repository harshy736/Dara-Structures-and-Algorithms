import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int p = scn.nextInt();
        int n = power(b,p);
        System.out.print(n);
    }

    public static int power(int x, int n){
        if(x==1 || n == 0){
            return 1;
        }else{
            return x*power(x,n-1);
        }
    }

}
