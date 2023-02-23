package Arrays;

public class setZero {


    public static void setZero(int[][] intArray, int matrixSize) {
        // TODO
        for (int i=0; i<matrixSize-1; i++){
            for (int j=0; j<matrixSize; j++){
                if(intArray[i][j] == 0){
                    for (int k=0; k<matrixSize-1; k++){
                        intArray[k][j] = 0;

                    }
                }
            }
        }
        for (int i=0; i<matrixSize-1; i++){
            for (int j=0; j<matrixSize; j++){
                System.out.print(intArray[i][j]);

            }
            System.out.println();

        }


    }
    public static void main(String[] args){
        int [][]arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZero(arr, 4);



    }
}
