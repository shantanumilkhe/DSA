package Recursion;
import java.util.ArrayList;
import java.util.List;

public class kSum {
    static int[] arr = {1,2,1,3};
    static int n = arr.length;

    static int target = 3;
    public static void printing(ArrayList<Integer> arr){
        System.out.print("{");
        for (int element : arr){
            System.out.print(element + "-> ");
        }
        System.out.print("}");
        System.out.println();
    }



    public static void ksum(int i ,ArrayList<Integer> subs, int sum){
        if(i>=n){
            if(sum==target){
                printing(subs);
            }
            return;
        }
        // taking the element
        subs.add(arr[i] );
        sum = sum + subs.get(subs.size()-1);
        ksum(i+1, subs, sum);

        // not taking the element
        int removed = subs.remove(subs.size()-1);
        sum = sum -removed;

       ksum(i+1, subs, sum);
    }

    public static boolean k1sum(int i ,ArrayList<Integer> subs, int sum){
        if(i>=n){
            if(sum==target){
                printing(subs);
                return true;
            }
            return false;
        }
        // taking the element
        subs.add(arr[i] );
        sum = sum + subs.get(subs.size()-1);

       if(k1sum(i + 1, subs, sum)){
           return true;
       }

        // not taking the element
        int removed = subs.remove(subs.size()-1);
        sum = sum -removed;

        if(k1sum(i + 1, subs, sum)){
            return true;
        };
        return false;
    }

    public static int Countksum(int i ,ArrayList<Integer> subs, int sum){
        int count =0;
        if(i>=n){
            if(sum==target){

                count++;
            }
            return count;
        }
        // taking the element
        subs.add(arr[i] );
        sum = sum + subs.get(subs.size()-1);

        count = count + Countksum(i+1, subs, sum);

        // not taking the element
        int removed = subs.remove(subs.size()-1);
        sum = sum -removed;

        count = count + Countksum(i+1, subs, sum);
        return count;
    }

    public static void main(String[] args){
        ArrayList<Integer> subs = new ArrayList<>();
        //ksum(0, subs,0 );
        k1sum(0, subs, 0);
        int c =Countksum(0, subs, 0);
        System.out.println(c);
    }
}
