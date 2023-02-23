package Arrays;

public class pal {
    public static void main(String[] args){
        int x = 4444;
        int palindromeX = 0;
        int inputX = x;
        while(x>0){
            System.out.println(palindromeX*10+" + "+ x%10);
            palindromeX = palindromeX*10 + (x % 10);

            x = x/10;
        }
        boolean t = palindromeX==inputX;
        System.out.println(t);
    }
}
