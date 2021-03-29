import java.io.*;
import java.util.*;

public class Main {
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      //first elements of all the lists
      for(int i = 0; i < lists.size(); i++){
          pq.add(new Pair(i, 0, lists.get(i).get(0)));
      }
      
      while(pq.size() > 0){
          Pair p = pq.remove();
          rv.add(p.val);
          
          p.idx++;
          if(p.idx < lists.get(p.lno).size()){
              p.val = lists.get(p.lno).get(p.idx);
              pq.add(p);
          }
      }

      return rv;
   }
   
   public static class Pair implements Comparable<Pair>{
       int lno;
       int idx;
       int val;
       
       Pair(int lno, int idx, int val){
           this.lno = lno;
           this.idx = idx;
           this.val = val;
       }
       
       public int compareTo(Pair o){
           return this.val - o.val;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
