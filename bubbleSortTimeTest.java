

import java.util.*;
import java.io.*;
class bubbleSortTimeTest{
    public static int bubbleSort(int[] arr){
        int swaps, last_swaps = 0;
        int items_sorted = 0;
        do{
            swaps = 0;
            for (int i = 0; i < arr.length - 1; i++){
                for (int j = i; j < arr.length; j++){
                    if (arr[j] < arr[i]){
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        swaps++;
                    }
                }
            }
            if(swaps > 0){
                last_swaps = swaps;
            }
            items_sorted++;
        }
        while(swaps>0);
        return items_sorted;
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
            items_sorted += bubbleSort(arr);
            long stopTime = System.nanoTime();
            total_time += stopTime - startTime;

            count++;
        }
        int avg_time = total_time/1000;
        System.out.printf("Items sorted: %d\n", items_sorted);
        System.out.printf("Average runtime: %d\n", avg_time);
    }
}