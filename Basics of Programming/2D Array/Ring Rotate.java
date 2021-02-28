import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = scn.nextInt();
            }
        }
        int s = scn.nextInt();
        int r = scn.nextInt();
        rotateshell(a,s,r);
        display(a);
    }
  
    public static void rotateshell(int[][] a,int s,int r){
        int[] oned = fillfromshell(a,s);
        rotate(oned,r);
        fillintoshell(a,oned,s);
    }
  
    public static int[] fillfromshell(int[][] a,int s){
        int rb=s-1,cb=s-1,re=a.length-s,ce=a[0].length-s,idx=0;
        int size=2*(re+ce-cb-rb);
        int[] oned = new int[size];
        for(int i=rb;i<re;i++){
            oned[idx++] = a[i][cb];
        }
        for(int i=cb;i<ce;i++){
            oned[idx++] = a[re][i];
        }
        for(int i=re;i>rb;i--){
            oned[idx++] = a[i][ce];
        }
        for(int i=ce;i>cb;i--){
            oned[idx++] = a[rb][i];
        }
        return oned;
    }
    
    public static void rotate(int[] oned,int r){
        r=r%oned.length;
        if(r<0){
            r+=oned.length;
        }
        reverse(oned,0,oned.length-r-1);
        reverse(oned,oned.length-r,oned.length-1);
        reverse(oned,0,oned.length-1);
    }
  
    public static void fillintoshell(int[][] a, int[] oned,int s){
        int rb=s-1,cb=s-1,re=a.length-s,ce=a[0].length-s,idx=0;
        for(int i=rb;i<re;i++){
            a[i][cb] = oned[idx++];
        }
        for(int i=cb;i<ce;i++){
            a[re][i] = oned[idx++];
        }
        for(int i=re;i>rb;i--){
            a[i][ce] = oned[idx++];
        }
        for(int i=ce;i>cb;i--){
            a[rb][i] = oned[idx++];
        }
    }
  
    public static void reverse(int[] oned,int li, int ri){
        while(li<ri){
            int temp = oned[li];
            oned[li] = oned[ri];
            oned[ri] =temp;
            li++;
            ri--;
        }
    }
  
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
