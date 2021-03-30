import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      boolean[][] visited = new boolean[m][n];
      int islands = 0;
      
      for(int r = 0; r < m; r++){
          for(int c = 0; c < n; c++){
              if(arr[r][c] == 0 && visited[r][c] == false){
                  numIslands(arr, r, c, visited);
                  
                  islands++;
              }
          }
      }
      
      System.out.println(islands);
   }
   
   public static void numIslands(int[][] arr, int r, int c, boolean[][] visited){
       if(r < 0 || r >= arr.length || c < 0 || c >= arr[0].length || visited[r][c] == true || arr[r][c] == 1){
           return;
       }
       
       visited[r][c] = true;
       
       //4 directions for every cell
       numIslands(arr, r - 1, c, visited);//north
       numIslands(arr, r + 1, c, visited);//south
       numIslands(arr, r, c - 1, visited);//east
       numIslands(arr, r, c + 1, visited);//west
   }

}
