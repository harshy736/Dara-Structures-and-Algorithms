/*
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> s = getMazePaths(1,1,n,m);
        System.out.print(s);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> ep = new ArrayList<>();
            ep.add("");
            return ep;
        }
        ArrayList<String> p = new ArrayList<>();
        for(int i=1;i<=dc-sc;i++){
            ArrayList<String> ph = getMazePaths(sr,sc+i,dr,dc);
            for(String p1:ph){
                p.add("h" + i + p1);
            }
        }
        for(int i=1;i<=dr-sr;i++){
            ArrayList<String> pv = getMazePaths(sr+i,sc,dr,dc);
            for(String p1:pv){
                p.add("v" + i + p1);
            }
        }
        for(int i=1;i<=dc-sc && i<=dr-sr;i++){
            ArrayList<String> pd = getMazePaths(sr+i,sc+i,dr,dc);
            for(String p1:pd){
                p.add("d" + i + p1);
            }
        }
        return p;
    }

}
