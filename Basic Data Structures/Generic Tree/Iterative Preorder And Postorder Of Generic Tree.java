import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  public static class Pair{
      Node node;
      int state;
      
      Pair(Node node, int state){
          this.node = node;
          this.state = state;
      }
  };

  public static void IterativePreandPostOrder(Node node) {
    Stack<Pair> st = new Stack<>();
    Queue<Integer> pre = new ArrayDeque<>();
    Queue<Integer> post = new ArrayDeque<>();
    
    Pair p = new Pair(node, -1);
    st.push(p);
    
    while(st.size() > 0){
        Pair pr = st.peek();
        
        if(pr.state == -1){
            pre.add(pr.node.data);
            pr.state++;
        }else if(pr.state == pr.node.children.size()){
            post.add(pr.node.data);
            st.pop();
        }else{
            Pair np = new Pair(pr.node.children.get(pr.state), -1);
            st.push(np);
            pr.state++;
        }
    }
    
    while(pre.size() > 0)
    {
        System.out.print(pre.remove() + " ");
    }
    
    System.out.println();
    
    while(post.size() > 0){
        System.out.print(post.remove() + " ");
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    IterativePreandPostOrder(root);
  }

}
