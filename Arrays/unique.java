package Arrays;

public class unique {
    public static void isUnique(int[] intArray) {
        int currentVal= 0;
        boolean isunique = true;
        for (int i = 0; i<intArray.length; i++){
            for (int j = i+1; j<intArray.length; j++){
                if(intArray[i]==intArray[j]){
                    isunique = false;
                }
            }
        }
        System.out.println(isunique);
    }
    public static void main(String[] args){
        int []arr = {1,2,3,4,5,6,8,9,10, 10};
        isUnique(arr);
    }
}
