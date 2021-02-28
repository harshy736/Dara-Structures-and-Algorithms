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
      
        int i=0,j=0,d=0;
        while(true){
            d=(d+a[i][j])%4;
            if(d==0){
                j++;
            }
            else if(d==1){
                i++;
            }
            else if(d==2){
                j--;
            }
            else if(d==3){
                i--;
            }
            
            if(i<0){
                i++;
                break;
            }
            else if(i==n){
                i--;
                break;
            }
            else if(j==m){
                j--;
                break;
            }
            else if(j<0){
                j++;
                break;
            }
        }
        System.out.print(i + "\n" + j);
    }

}
