

import java.util.*;
import java.io.*;
class bubbleSort{
    public static void bubbleSort(int[] arr){
        int swaps, last_swaps = 0;
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
        }
        while(swaps>0);

        System.out.print("Bubble Sorted values: ");
        for(int i=0;i<arr.length;i++){
            if(i == arr.length-1){
                System.out.printf("%d\n", arr[i]);
            }
            else{
                System.out.printf("%d, ", arr[i]);
            }
        }
        System.out.println("Bubble Sort swaps: "+ last_swaps);
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
        bubbleSort(arr);
    }
}