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
      
        int[] min = new int[n];
        for(int i=0;i<n;i++){
            int min1 = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(a[i][j]<min1){
                    min1 = a[i][j];
                }
            }
            min[i] = min1;
        }
      
        int[] max = new int[n];
        for(int j=0;j<n;j++){
            int max1 = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(a[i][j]>max1){
                    max1 = a[i][j];
                }
            }
            max[j] = max1;
        }
      
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(min[i]==max[j]){
                    System.out.print(min[i]);
                    return;
                }
            }
        }
        System.out.print("Invalid input");
    }
}
