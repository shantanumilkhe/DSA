package Arrays;

public class maxProduct {
    public static void maxProduct(int[] intArray) {
        // TODO
        int max = Integer.MIN_VALUE;
        int highi = 0;
        int highj = 0;
        int currentVal = 0;
        for (int i = 0; i<intArray.length; i++){
            for (int j = i+1; j<intArray.length; j++){
                currentVal = intArray[i]*intArray[j];
                if(currentVal>max){
                    max = currentVal;
                    highi = i;
                    highj = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(intArray[highi]+" "+intArray[highj]);
    }
    public static void main(String[] args){
        int []arr = {1,2,3,4,5,6,8,9,10};
        maxProduct(arr);


    }
}
