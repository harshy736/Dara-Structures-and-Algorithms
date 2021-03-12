import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return mainQ.size();
    }

    void push(int val) {
      // write your code here
      mainQ.add(val);
    }

    int pop() {
      // write your code here
      if(mainQ.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      else{
          int val = 0;
          while(size() > 0)
          {
             val = mainQ.remove();//extracting in FIFO order
             helperQ.add(val);//copying data into helper
          }
          //val -> contains last element of queue
          //copy back data
          //lastelment doesn't copy back
          while(helperQ.size() > 1){
              int nval = helperQ.remove();
              mainQ.add(nval);
          }
          helperQ.remove();
          
          return val;
      }
    }

    int top() {
      // write your code here
      if(size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      else{
          int val = 0;
          while(size() > 0)
          {
             val = mainQ.remove();//extracting in FIFO order
             helperQ.add(val);//copying data into helper
          }
          //val -> contains last element of queue
          //copy back data
          while(helperQ.size() > 0){
              int nval = helperQ.remove();
              mainQ.add(nval);
          }
          
          return val;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}
