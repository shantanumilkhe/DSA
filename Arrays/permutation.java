package Arrays;

public class permutation {
    public static void permutaiton(int[] intArray1, int[] intArray2){
        int j =intArray2.length;
        for (int i = 0; i<intArray1.length; i++){

            if(intArray1[i]!=intArray2[j-i-1]){
                System.out.println("no");
            }
        }
    }

    public static void main(String[] args){
        int []arr = {1,2,3};
        int []arr2 = {3,3,1};
        permutaiton(arr, arr2);

    }
}
