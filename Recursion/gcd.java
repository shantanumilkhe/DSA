package Recursion;

public class gcd {

    public static int gcd(int a, int b){
        if (a < 0 || b < 0) {
            return -1;
        }
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args){
        System.out.println(gcd(12, 8));
    }
}
