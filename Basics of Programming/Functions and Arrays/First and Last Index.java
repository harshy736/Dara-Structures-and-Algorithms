import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i=0;i<n;i++){
        a[i] = scn.nextInt();
    }
  
    int f = scn.nextInt();
    int beg=0,end=n-1,first=-1;
    while(beg<=end){
        int mid=(beg+end)/2;
        if(f<a[mid]){
            end = mid-1;
        }
        else if(f>a[mid]){
            beg = mid+1;
        }
        else{
            first=mid;
            end=mid-1;
        }
    }
    System.out.println(first);
    beg=0;
    end=n-1;
    int last = -1;
    while(beg<=end){
        int mid=(beg+end)/2;
        if(f<a[mid]){
            end = mid-1;
        }
        else if(f>a[mid]){
            beg = mid+1;
        }
        else{
            last=mid;
            beg=mid+1;
        }
    }
    System.out.println(last);
 }

}
