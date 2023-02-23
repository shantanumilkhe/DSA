package Recursion;

public class reverse {

    public static int[] twoPointer(int[] arr, int l, int r){
        if(r<l){
            return arr;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        twoPointer(arr, l+1, r-1);
        return arr;
    }
    public static int[] singlePointer(int[] arr, int i,int n){
        if(i>=n/2){
            return arr;
        }
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        singlePointer(arr, i+1, arr.length);
        return arr;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        arr = singlePointer(arr, 0,arr.length);
        for (int i =0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
