import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int f = scn.nextInt();
        System.out.println(lastIndex(arr, n-1, f));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(arr[idx]==x){
            return idx;
        }
        return lastIndex(arr,idx-1,x);
    }
}
