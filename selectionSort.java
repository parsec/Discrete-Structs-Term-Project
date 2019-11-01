import java.util.*;
import java.io.*;

class selectionSort{
    public static void selectionSort(int[] arr){
        int i = 0;
        int j = 0;
        int swaps = 0;
        for (i = 0; i < arr.length - 1; i++){
            int minPos = i;
            for (j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minPos])
                    minPos = j;
            }
            if (i != minPos && minPos < arr.length){
                int temp = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = temp;
            }
            swaps++;
        }

        System.out.print("Selection Sorted values: ");
        for(i=0;i<arr.length;i++){
            if(i == arr.length-1){
                System.out.printf("%d\n", arr[i]);
            }
            else{
                System.out.printf("%d, ", arr[i]);
            }
        }
        System.out.println("Selection Sort swaps: "+ swaps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input array size: ");
        int arr_size = sc.nextInt();
        int[] arr = new int[arr_size];

        int i = 0;
        int min = 1;
        int max = 100;
        long epoch = System.currentTimeMillis();
        Random rand = new Random(epoch);

        while(i<arr.length){
            arr[i] = rand.nextInt((max - min) + 1) + min;
            i++;
        }
        System.out.println(arr);
        selectionSort(arr);
    }
}