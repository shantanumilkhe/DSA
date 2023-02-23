package Arrays;

public class searcharray {
    public static int searchInArray(int[] intArray, int valueToSearch) {
            for(int i: intArray){
                if(intArray[i]==valueToSearch){
                    System.out.println("Value found at index "+i);
                    return 1;
                }
            }
        System.out.println("Value Not found");
        return 0;
    }
    public static void main(String[] args){
        int []arr = new int[]{1,2,3,4,5,6,8,9,10};
        searchInArray(arr, 8);

    }
}
