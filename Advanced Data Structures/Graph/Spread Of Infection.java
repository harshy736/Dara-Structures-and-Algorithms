import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   public static class Pair{
       int v;
       int tm;
       
       Pair(int v, int tm){
           this.v = v;
           this.tm = tm;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      boolean[] visited = new boolean[vtces];
      int ip = 0;
      
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, 1));
      
      while(q.size() > 0){
          Pair rem = q.remove();
          
          if(visited[rem.v] == true){
              continue;
          }
          visited[rem.v] = true;
          
          if(rem.tm > t){
              continue;
          }
          
          ip++;
          
          for(Edge edge : graph[rem.v]){
              if(visited[edge.nbr] == false){
                  q.add(new Pair(edge.nbr, rem.tm + 1));
              }
          }
          
      }
      
      System.out.println(ip);
      
   }
   
}
