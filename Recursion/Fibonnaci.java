package Recursion;

public class Fibonnaci {
    static int Fibnonnaci (int n){
        if(n <0){
            return -1;
        }
        if(n == 1 || n ==0){
            return n;
        }
        else{
            return Fibnonnaci(n-1) + Fibnonnaci(n-2);
        }

    }
    public static void main(String[] args) {
        int n = Fibnonnaci(5);
        int[] dp = new int[n+1];
        System.out.println(n);

    }

}

