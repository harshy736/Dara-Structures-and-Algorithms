import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = scn.nextInt();
        }
        int x = maxOfArray(a,0);
        System.out.print(x);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(arr.length==idx){
            return 0;
        }
        return Math.max(arr[idx],maxOfArray(arr,idx+1));
    }

}
