import java.io.*;
import java.util.*;

public class Main {
   static class Edge implements Comparable<Edge>{
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
      
      public int compareTo(Edge o){
          return this.wt - o.wt;
      }
   }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      boolean[] visited = new boolean[vtces];
      visited[0] = true;
      
      PriorityQueue<Edge> pq = new PriorityQueue<>();
      for(Edge edge : graph[0]){
          pq.add(edge);
      }
      
      while(pq.size() > 0){
          Edge rem = pq.remove();
          
          if(visited[rem.nbr] == true){
              continue;
          }
          visited[rem.nbr] = true;
          
          System.out.println("[" + rem.nbr + "-" + rem.src + "@" + rem.wt + "]");
          
          for(Edge edge : graph[rem.nbr]){
              if(visited[edge.nbr] == false){
                  pq.add(edge);
              }
          }
      }
   }

}
