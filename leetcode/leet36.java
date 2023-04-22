package leetcode;

import java.util.HashMap;
import java.util.HashSet;


public class leet36 {

    public static boolean sud(String[][] board){

        HashSet<String> set = new HashSet<>();

      for(int i =0; i<9; i++){
          for(int j =0; j<9; j++) {
              if (board[i][j] == ".") {
                  if (!set.add("row" + i + board[i][j])) return false;
                  if (!set.add("col" + j + board[i][j])) return false;
                  int box = (i / 3) * 3 + (j / 3);
                  if (!set.add("box" + box + board[i][j])) return false;
              }
          }
      }
        return true ;
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Write your code here

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
