package Arrays;

public class findmissing {


    public static void missing(int[] arr){
        int[] original = {1,2,3,4,5,6,7,8,9,10};
        int sumo =0;
        for (int i =0; i< original.length; i++ ){
            sumo = sumo + original[i];
        }
        int suma =0;
        for (int i =0; i< arr.length; i++ ){
            suma = suma + arr[i];
        }
       int miss = sumo-suma;
        System.out.println(miss);
    }

    public static void main(String[] args){
        int []arr = new int[]{1,2,3,4,5,6,8,9,10};
        missing(arr);
    }
}
