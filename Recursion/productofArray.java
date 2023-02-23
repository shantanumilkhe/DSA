package Recursion;

public class productofArray {

    public static int product(int n[]){
        if(n== null){
            return 1;
        }
        else{

            return n[(n.length-1)]*product(n);
        }
    }
    public static void main(String[] args){
        int []arr = {1,2,3,4,5};

        System.out.println(product(arr));

    }
}
