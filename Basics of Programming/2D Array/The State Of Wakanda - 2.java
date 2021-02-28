import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j] = scn.nextInt();
            }
        }
        for(int x=0;x<n;x++){
            int i=0,j=x;
            while(i<n && j<n){
                System.out.println(a[i++][j++]);
            }
        }
    }
}
