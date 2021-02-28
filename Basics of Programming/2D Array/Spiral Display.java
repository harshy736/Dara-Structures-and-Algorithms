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
      
        int rb=0,cb=0,re=n-1,ce=m-1,c=0;
        while(c<n*m){
            for(int i=rb;i<=re && c<n*m;i++){
                System.out.println(a[i][cb]);
                c++;
            }
            cb++;
            for(int i=cb;i<=ce && c<n*m;i++){
                System.out.println(a[re][i]);
                c++;
            }
            re--;
            for(int i=re;i>=rb && c<n*m;i--){
                System.out.println(a[i][ce]);
                c++;
            }
            ce--;
            for(int i=ce;i>=cb && c<n*m;i--){
                System.out.println(a[rb][i]);
                c++;
            }
            rb++;
        }
    }

}
