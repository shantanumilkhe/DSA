package DP.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class generateSub {



    public static void combination(String[] arr, String[] data, int start, int end, int index, int r)
    {
        if(index == r)
        {
            for(int j = 0; j < arr.length; j++)
                System.out.print(data[j]+" ");
            System.out.println();
            return;
        }
        for(int i = start; i <= end; i++)
        {
            data[index] = arr[i];
            combination(arr, data, i+1, end, index+1, r);
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of characters: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        String[] sub = new String[n];

        for(int i = 0; i<n; i++){
            System.out.print("Enter element no."+(i+1)+" : ");
            arr[i] = sc.nextLine();
        }

        combination(arr,sub,0,n-1,0,arr.length);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " ns");
    }
}
