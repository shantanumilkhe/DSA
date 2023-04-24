package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class leet20 {
    public static boolean valid(String s){
        Stack<Character> st = new Stack<>();
         LinkedList<Integer> list = new LinkedList<>();
         list.removeFirst();
        int n  = s.length();
        for(int i =0; i<n; i++){
            char c = s.charAt(i);
            if(c=='('|| c=='['|| c=='{'){
                st.push(c);
            }
            if(c==')'&& st.peek()=='(') st.pop();
            if(c==']'&& st.peek()=='[') st.pop();
            if(c=='}'&& st.peek()=='{') st.pop();
        }
        if(st.isEmpty()) return true;
        else return false;
    }
    public static void main(String[] args) {


        long startTime = System.nanoTime();

        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
