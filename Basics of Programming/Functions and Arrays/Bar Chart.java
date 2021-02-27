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

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
    }
    
    int m = max(arr, n);
    for(int i=1;i<=m;i++){
        for(int j=0;j<n;j++){
            if((m-i)<arr[j]){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
 }

}
