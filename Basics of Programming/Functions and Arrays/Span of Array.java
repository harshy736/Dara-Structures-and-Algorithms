import java.io.*;
import java.util.*;

public class Main{

public static int max(int[] arr, int n){
    int m=0;
    for(int i=0;i<n;i++){
        if(arr[i]>m){
            m=arr[i];
        }
    }
    return m;
}
public static int min(int[] arr, int n){
    int m=Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
        if(arr[i]<m){
            m=arr[i];
        }
    }
    return m;
}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
    }
  
    int m2 = max(arr, n);
    int m1 = min(arr, n);
    System.out.print(m2-m1);
 }

}
