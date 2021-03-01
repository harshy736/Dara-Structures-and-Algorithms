import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int f = factorial(n);
        System.out.print(f);
    }

    public static int factorial(int n){
        if(n==0 ||n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }

}
