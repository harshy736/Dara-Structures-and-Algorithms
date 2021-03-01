import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		for(int i=0;i<str.length();i++){
		    for(int j=i+1;j<=str.length();j++){
		        String s = str.substring(i,j);
		        if(isPalindrome(s)){
		            System.out.println(s);
		        }
		    }
		}
	}
    
    public static boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(s.length()-i-1);
            if(ch1!=ch2){
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}
}
