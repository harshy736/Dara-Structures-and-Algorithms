/*
1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.
*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> s = getStairPaths(n);
        System.out.print(s);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> b = new ArrayList<>();
            b.add("");
            return b;
        }
        else if(n<0){
            ArrayList<String> b = new ArrayList<>();
            return b;
        }
        ArrayList<String> p1 = getStairPaths(n-1);
        ArrayList<String> p2 = getStairPaths(n-2);
        ArrayList<String> p3 = getStairPaths(n-3);
        ArrayList<String> p = new ArrayList<>();
        for(String path:p1){
            p.add(1+path);
        }
        for(String path:p2){
            p.add(2+path);
        }
        for(String path:p3){
            p.add(3+path);
        }
        return p;
    }

}
