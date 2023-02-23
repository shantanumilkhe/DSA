package Recursion;

public class SumOf {

        static int Sum(int n){
            if (n==0 || n <0){
                return 0;
            }else {
                return n%10 + Sum(n/10);
            }
        }
    public static void main(String[] args){
        int n =143;
        System.out.println(Sum(n));
    }
    }

