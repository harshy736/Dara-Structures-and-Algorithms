import java.util.*;
  
public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getSum(b, n1, n2);
    System.out.println(d);
 }

 public static int getSum(int b, int n1, int n2){
     int num1 = getValueIndecimal(n1,b);
     int num2 = getValueIndecimal(n2,b);
     int ans = getValueInBase(num1+num2,b);
     return ans;
 }

 public static int getValueIndecimal(int n, int b){
    int sum=0,p=1;
    while(n>0){
        sum+=(n%10)*p;
        p *= b;
        n=n/10;
    }
    return sum;
 }
 
 public static int getValueInBase(int n, int b){
     int sum=0,p=1;
     while(n>0){
         sum += (n%b) * p;
         p *= 10;
         n /= b;
     }
     return sum;
 }
}
