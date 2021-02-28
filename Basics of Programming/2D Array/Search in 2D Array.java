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
        
        int f = scn.nextInt();
        for(int i=0;i<n;i++){
            if(f < a[i][0]){
                System.out.print("Not Found");
                return;
            }else if(f > a[i][n - 1]){
                continue;
            }else{
                for(int j=0;j<n;j++){
                    if(a[i][j]==f){
                        System.out.print(i + "\n" + j);
                        return;
                    }
                }
            }
        }
        System.out.print("Not Found");
        
    }
}
