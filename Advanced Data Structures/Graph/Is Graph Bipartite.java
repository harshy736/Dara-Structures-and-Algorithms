import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

    public static class Pair{
        int v;
        int level;
        
        Pair(int v, int level){
            this.v = v;
            this.level = level;
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

      boolean[] visited = new boolean[graph.length];
      
      for(int v = 0;  v < graph.length; v++){
          if(visited[v] == false){
              boolean bip = isBipartite(graph, v, visited);
              if(bip == false){
                  System.out.println(false);
                  return;
              }
          }
      }
      
      System.out.println(true);
   }
   
   public static boolean isBipartite(ArrayList<Edge>[] graph, int src, boolean[] visited){
       ArrayList<Pair> os = new ArrayList<>();
       ArrayList<Pair> es = new ArrayList<>();
      
       Queue<Pair> q = new ArrayDeque<>();
       q.add(new Pair(src, 0));
       
       while(q.size() > 0){
           Pair rem = q.remove();
           
           if(visited[rem.v] == true){//cycle
               if(os.size() != es.size()){
                   return false;
               }else{
                   return true;
               }
           }
           
           visited[rem.v] = true;
           
           if(rem.level % 2 == 0){
               es.add(rem);
           }else{
               os.add(rem);
           }
           
           for(Edge edge : graph[rem.v]){
               if(visited[edge.nbr] == false){
                   q.add(new Pair(edge.nbr, rem.level + 1));
               }
           }
       }
       
       return true;
   }
}
