package Recursion;

public class power {

    public static int power(int n, int i){
        if (i<=0){
            return 1;
        }
        else{
            return n*power(n, i-1);
        }
    }

    public static void main(String[] args){
        System.out.println(power(2,5));
    }
}
