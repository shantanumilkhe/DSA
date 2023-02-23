package DSA.SortingAlgos;
import java.util.Random;

public class mergeSort {
  
  public static void main(String[] args) {
    Random rand = new Random();
    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(1000000);
    }
    System.out.println("Before: ");
    printArray(numbers);
    
    MergeSort(numbers);
    
   System.out.println("after: ");
    printArray(numbers);

  }

  public static void MergeSort(int[] input)
  {
    int n = input.length;
    if(n<2){
      return;
    }
    int mid = n/2;
    int[] left = new int[mid];
    int[] right = new int[n-mid];

    for(int i =0; i<mid; i++){
      left[i]= input[i];
    }
    for(int i =mid; i<n; i++){
      right[i-mid]= input[i];
    }
    MergeSort(left);
    MergeSort(right);

    merge(input, left, right);
    
  }

  public static void merge(int[] input, int[] left, int[] right)
  {
    int n = input.length;
    int leftSize = left.length;
    int rightSize = right.length;

    int i = 0,j = 0, k = 0;

    while(i< leftSize && j< rightSize){
      if( left[i]<=right[j] ){
        input[k]=left[i];
        i++;
      }else{
        input[k]= right[j];
        j++;
      }
      k++;
    }

    while(i< leftSize){
      input[k] = left[i];
      k++;
      i++;
    }
     while(j< rightSize){
      input[k] = right[j];
      k++;
      j++;
    }

  
}
  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "-> ");
    }
  }
}