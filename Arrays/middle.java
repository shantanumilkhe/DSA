package Arrays;

public class middle {
    public static void  middle(int[] arr) {
        int n = arr.length;
        int[] middleA= new int[n-2];
        for (int i = 1; i<n-1; i++){
            middleA[i-1] = arr[i];
        }
        for (int i = 0; i<middleA.length; i++){
           System.out.println(middleA[i]);
        }
    }
    public static void main(String[] args){
        int []arr = new int[]{1,2,3,4,5,6,8,9,10};
        middle(arr);


    }
}
