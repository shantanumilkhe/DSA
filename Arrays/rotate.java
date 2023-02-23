package Arrays;

public class rotate {

    public static void rotate(int[][] intArray){
        int[][] rotatedArray = new int[3][3];
        for(int i= 0; i< 3; i++){
            for (int j = 0; j< 3; j++){
                rotatedArray[2-i][2-j]= intArray[i][j];
            }
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.println("arr[" + i + "][" + j + "] = "
                        + intArray[i][j]);
            }
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.println("arr[" + i + "][" + j + "] = "
                        + rotatedArray[i][j]);
    }
    }}


    public static void main(String[] args){
        int [][]arr = {{1,2,3},  {4,5,6}, {7,8,9}}  ;
        rotate(arr);
    }
}
