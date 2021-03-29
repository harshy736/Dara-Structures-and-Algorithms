import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      data.add(val);
      upHeapify(data.size() - 1);
    }
    
    private void upHeapify(int ch){
        if(ch == 0){
            return;
        }
        
        int pi = (ch - 1)/2;
        
        if(data.get(ch) < data.get(pi)){
            swap(pi, ch);
            upHeapify(pi);
        }
    }
    
    private void swap(int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i, jth);
        data.set(j, ith);
    }

    public int remove() {
      if(this.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      
      swap(0, data.size() - 1);
      int val = data.remove(data.size() - 1);
      downHeapify(0);
      return val;
    }
    
    private void downHeapify(int pi){
        int mini = pi;
        int lc = 2 * pi + 1;
        if(lc < data.size() && data.get(lc) < data.get(mini)){
            mini = lc;
        }
        
        int rc = 2 * pi + 2;
        if(rc < data.size() && data.get(rc) < data.get(mini)){
            mini = rc;
        }
        
        if(mini != pi){
            swap(mini, pi);
            downHeapify(mini);
        }
    }

    public int peek() {
      if(this.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      
      return data.get(0);
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
