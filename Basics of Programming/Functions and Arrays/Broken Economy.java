import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i=0;i<n;i++){
        a[i]=scn.nextInt();
    }
  
    int data = scn.nextInt();
    int low=0,high=n-1,ceil=Integer.MAX_VALUE,floor=Integer.MIN_VALUE;
  
    while(low<=high){
        int mid=(low+high)/2;
        if(data<a[mid]){
            high=mid-1;
            ceil=a[mid];
        }else if(data>a[mid]){
            low=mid+1;
            floor=a[mid];
        }else{
            break;
        }
    }
  
    System.out.print(ceil + "\n" + floor);
 }
}
