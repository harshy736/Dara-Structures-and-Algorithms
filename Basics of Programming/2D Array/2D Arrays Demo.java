import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
  
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int temp = scn.nextInt();
            System.out.print(temp + " ");
        }
        System.out.println();
    }
 }
}
