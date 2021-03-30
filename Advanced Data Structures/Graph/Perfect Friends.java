import java.io.*;
import java.util.*;

public class Main {
   public static class Edge{
       int src;
       int nbr;
       
       Edge(int src, int nbr){
           this.src = src;
           this.nbr = nbr;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());//no. of  friends = vertex
      int k = Integer.parseInt(br.readLine());//no. of clubs = edges
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      
      for(int v = 0; v < graph.length; v++){
          graph[v] = new ArrayList<>();
      }
      
      for(int e = 0; e < k; e++){
          String line = br.readLine();
          String[] parts = line.split(" ");
          
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);
          
          graph[v1].add(new Edge(v1, v2));
          graph[v2].add(new Edge(v2, v1));
      }
      
      boolean[] visited = new boolean[n];
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      for(int v = 0; v < graph.length; v++){
          if(visited[v] == false){
              ArrayList<Integer> comp = new ArrayList<>();
              drawTree(graph, v, comp, visited);
              
              comps.add(comp);
          }
      }
      
      int pairs = 0;
      
      for(int i = 0; i < comps.size(); i++){
          int c1 = comps.get(i).size();
          for(int j = i + 1; j < comps.size(); j++){
              pairs += c1 * comps.get(j).size();
          }
      }
      
      System.out.println(pairs);
      
   }
   
   
   public static void drawTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
       visited[src] = true;
       comp.add(src);
       
       for(Edge edge : graph[src]){
           if(visited[edge.nbr] == false){
               drawTree(graph, edge.nbr, comp, visited);
           }
       }
   }

}
