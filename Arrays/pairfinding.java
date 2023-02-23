package Arrays;

public class pairfinding {
    public static void findPair(int[] arr, int n){
        for(int i= 0; i< arr.length; i++){
            for (int j = i+1; j< arr.length-i; j++){
                if(arr[i]+arr[j] == n){
                    System.out.println(arr[i] +" "+ arr[j]);
                }
            }
        }
    }

    public static void main(String[] args){
        int []arr = new int[]{1,2,3,4,5,6,8,9,10};
        findPair(arr, 8);

    }
}
