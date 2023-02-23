package Recursion;

public class printName {

    public static void name(int i, int n){

        if(i>n){
            return;
        }
        else{

            name(i+1,n);
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        name(1, 10);
    }
}
