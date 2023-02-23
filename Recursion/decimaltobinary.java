package Recursion;

public class decimaltobinary {

    public static int btd(int n){
        if(n==0){
            return 0;
        }
        else {
            return n%2 + 10*btd(n/2);
        }
    }

    public static void main(String[] args){
        System.out.println(btd(15));
    }
}
