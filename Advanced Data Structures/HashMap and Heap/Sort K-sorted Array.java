import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      int j = 0;
      for(int i = 0; i < arr.length; i++){
          if(i <= k){
              pq.add(arr[i]);
          }else{
              arr[j] = pq.remove();
              j++;
              pq.add(arr[i]);
          }
      }
      
      
      while(pq.size() > 0){
          arr[j++] = pq.remove();
      }
      
      for(int val : arr){
          System.out.println(val);
      }
   }

}
