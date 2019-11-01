import java.util.*;
import java.io.*;
import java.time.*;

class selectionSortTimeTest{
    public static int selectionSort(int[] arr){
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
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input array size: ");
        int arr_size = sc.nextInt();

        int count = 0;
        int items_sorted = 0;
        int total_time = 0;
        while(count < 1000){
            int[] arr = new int[arr_size];

            int i = 0;
            int min = 1;
            int max = arr_size*10;
            long epoch = System.currentTimeMillis();
            Random rand = new Random(epoch);

            while(i<arr.length){
                arr[i] = rand.nextInt((max - min) + 1) + min;
                i++;
            }
            long startTime = System.nanoTime();
            items_sorted += selectionSort(arr);
            long stopTime = System.nanoTime();
            total_time += stopTime - startTime;

            count++;
        }
        int avg_time = total_time/1000;
        System.out.printf("Items sorted: %d\n", items_sorted);
        System.out.printf("Average runtime: %d\n", avg_time);
    }
}