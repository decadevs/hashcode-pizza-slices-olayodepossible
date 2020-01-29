package com.possible.hashcode;


import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Main {
   private static HashCodePizza configParser;
    public static void main(String[] args)throws FileNotFoundException{
        int maxNumOfOrder = 17;
        int max = 0;
        int arr [] = {2, 6, 5, 8};
        int numPizzaType = arr.length;
        int arr1[] = new int[numPizzaType];
        System.arraycopy(arr,0,arr1,0, numPizzaType);
//        Arrays.sort(arr1);


        for(int i = numPizzaType -1 ; i >= 0; i--){
            if(arr1[i] < maxNumOfOrder){
                maxNumOfOrder = maxNumOfOrder - arr1[i];
                System.out.printf("%d%s",i," ");
                max++;
            }
        }
        System.out.println();
        System.out.println(max);
    }
}
