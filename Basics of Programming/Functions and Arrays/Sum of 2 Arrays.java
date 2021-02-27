import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a1 = new int[n];
    for(int i=0;i<n;i++){
        a1[i]=scn.nextInt();
    }
  
    int m = scn.nextInt();
    int[] a2 = new int[m];
    for(int i=0;i<m;i++){
        a2[i]=scn.nextInt();
    }
  
    int z=n>m?n:m;
    int i=n,j=m,carry=0,k=z;
    int[] a = new int[k];
    while(k>0){
        if(i>0 && j>0){
            int x=a1[i-1]+a2[j-1]+carry;
            a[k-1]=x%10;
            carry=x/10;
            i--;
            j--;
            k--;
        }
        else if(i>0){
            int x=a1[i-1]+carry;
            a[k-1]=x%10;
            carry=x/10;
            i--;
            k--;
        }
        else{
            int x=a2[j-1]+carry;
            a[k-1]=x%10;
            carry=x/10;
            j--;
            k--;
        }
    }
    for(int x=0;x<z;x++){
        System.out.println(a[x]);
    }
 }

}
