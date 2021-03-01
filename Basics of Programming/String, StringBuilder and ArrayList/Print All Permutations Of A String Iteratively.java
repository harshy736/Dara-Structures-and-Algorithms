import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		int len = str.length();
		int f = fact(len);
		for(int i=0;i<f;i++){
		    StringBuilder sb = new StringBuilder(str);
		    int temp = i;
		    for(int j=len;j>0;j--){
		        int q = temp/j;
		        int r = temp%j;
		        System.out.print(sb.charAt(r));
		        sb.deleteCharAt(r);
		        temp = q;
		    }
		    System.out.println();
		}
	}
	
	public static int fact(int n){
	    int val = 1;
	    for(int i=2;i<=n;i++){
	        val *= i;
	    }
	    return val;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}
