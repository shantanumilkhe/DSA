package Recursion;

public class sum {
    public static void sum(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        sum(i-1,sum+i);
    }
    public static int sumf(int sum){
        if(sum==0){
            return 0;
        }
        sum = sum + sumf(sum-1);
        return sum;

    }
    public static void main(String[] args){
        sum(4, 0);
        System.out.println(sumf(3));
    }
}
