package Graph;

class coordinate{
    int row;
    int column;
    int step;
    public coordinate(int row, int column, int step){
        this.row = row;
        this.column= column;
        this.step = step;
    }
}
public class distanceMatrix {


    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
