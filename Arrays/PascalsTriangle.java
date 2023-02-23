package Arrays;

public class PascalsTriangle {

    public static void Triangle(int Size) {
        // TODO
        int [][] arr = new int[Size][];

        for (int i=0; i<Size; i++){
            for (int k = 0; k< i+1; k++){
                arr[i][k] = 0;
            }
            arr[i][0] = 1;
            arr[i][i+1] = 1;

        }



    }
    public static void main(String[] args){
       // int [][]arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};



    }
}
