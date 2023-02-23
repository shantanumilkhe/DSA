package Recursion;

public class palindrome {

    public static boolean pal(int i, char[] str){
        boolean p;
        if(i>str.length/2){
            return true;
        }
        if(str[i]!=str[str.length-i-1]){
            return false;
        }else {
            p = pal(i+1, str);
        }
        return p;
    }
    public static void main(String[] args){
        String input = "lerrel";
        char[] inputArr = input.toCharArray();
        boolean res = pal(0,inputArr);
        System.out.println(res);
    }
}
