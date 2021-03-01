import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		char ch = str.charAt(0);
		String s = "";
		for(int i=1;i<str.length();i++){
		    char ch1 = str.charAt(i);
		    if(ch1!=ch){
		        s = s + ch;
		        ch = ch1;
		    }
		}
		s = s + ch;

		return s;
	}

	public static String compression2(String str){
		char ch = str.charAt(0);
		int count = 1;
		String s = "";
		for(int i=1;i<str.length();i++){
		    char ch1 = str.charAt(i);
		    if(ch1!=ch){
		        if(count==1){
		            s = s + ch;
    		        ch = ch1;
    		        count = 1;
		        } else{
    		        s = s + ch + count;
    		        ch = ch1;
    		        count = 1;
		        }
		    } else{
		        count++;
		    }
		}
		if(count==1){
		    s = s + ch;
		} else{
		    s = s + ch + count;
		}
		
		return s;
	}
  
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}
}
