import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
		StringBuilder sb = new StringBuilder(str);
		for(int i=0;i<sb.length();i++){
		    char ch = sb.charAt(i);
		    if(Character.isLowerCase(ch)){
		        ch = Character.toUpperCase(ch);
		    } else{
		        ch = Character.toLowerCase(ch);
		    }
		    sb.setCharAt(i,ch);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}
}
