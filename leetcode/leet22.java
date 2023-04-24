package leetcode;

import java.util.LinkedList;
import java.util.List;

public class leet22 {

    public static void gen(int open,int close, String s,int n, List<String> list){


        if(s.length()==n*2){
            list.add(s);
            return;
        }
        String openB = s+"(";
        if(open<n) gen(open+1, close, openB, n, list);
        String closeB = s+")";
        if(close<open) gen(open, close+1, closeB,n, list);
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        List<String> list = new LinkedList<>();
        String s = "";
        int n =4;
        gen(0,0,s,n, list);
        System.out.println(list);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
