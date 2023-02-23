package Recursion;
import java.util.ArrayList;
import java.util.Arrays;
public class subseq {

    static int[] arr = {4,4,4,1,4};
    static int n = arr.length;
    public static void printing(ArrayList<Integer> arr){
        System.out.print("{");
       for (int element : arr){
           System.out.print(element + "-> ");
       }
        System.out.print("}");
        System.out.println();
    }
    public static void sub(int i ,ArrayList<Integer> subs){
       if(i>=n){
           printing(subs);
           return;
       }
       // taking the element
        subs.add(arr[i] );
        sub(i+1, subs);

        // not taking the element
        subs.remove(subs.size()-1);
        sub(i+1, subs);
    }

    public static void main(String[] args){
        ArrayList<Integer> subs = new ArrayList<>();
        sub(0, subs);
    }
}
